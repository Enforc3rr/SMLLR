const keyGenDatabase = require("../models/keyGenModel");
const redis = require("redis");
const redisClient = redis.createClient();

exports.getKey = async (req,res)=>{
    redisClient.lrange("keys",0,-1,async (error,data)=>{

        if(error) console.log(error);

        if(data != null){
            await redisClient.llen("keys",async (err ,len)=>{
                if(len >= 5){
                    await redisClient.lpop("keys",(err, key)=>{
                        res.status(200).json({
                            success : true ,
                            key : key
                        });
                    });
                }else if(len < 5){
                    const newlyFetchedData = await keyGenDatabase.find({isBeingUsed: false}).limit(16-len);
                    newlyFetchedData.forEach(async (keyData )=>{
                         keyGenDatabase.findByIdAndUpdate(keyData._id,{
                            isBeingUsed : true
                        });
                        redisClient.lpush("keys",keyData.key);
                    });
                    await redisClient.lpop("keys",(err, key)=>{
                        res.status(200).json({
                            success : true ,
                            key : key
                        });
                    });
                }
            });
        }
    });
}

