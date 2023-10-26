const admim = require('../config/firebase')

function authMiddleware(request, response, next) {
  const headerToken = request.headers.authorization;
  if (!headerToken) {
    return response.send({ message: "No token provided" }).status(401);
  }

  if (headerToken && headerToken.split(" ")[0] !== "Bearer") {
    response.send({ message: "No admin" }).status(401);
  }

  const token = headerToken.split(" ")[1];
  admim
    .auth()
    .verifyIdToken(token)
    .then(() => next())
    .catch(() => response.send({ message: "Admin" }).status(403));
}

module.exports = authMiddleware;


/* const admim = require('../config/firebase')
class Middleware{
    async decodeToken(req, res, next){
        const token= req.headers.authorization.slip(' ')[1]
        try{
            const decodeValue = await admim.auth().verifyIdToken(token)
            if(decodeValue){
                return res.json({meessage: 'Admin entrou'})
                return next()
            }
            return res.json({meessage: 'nao é Admin'})
            return next()
        }catch(e){
            return res.json({meessage: 'Error'})
        }
    }
}

module.exports = new  Middleware() */

/* import admin from './firebase-service';


const getAuthToken = (req, res, next) => {
  if (
    req.headers.authorization &&
    req.headers.authorization.split(' ')[0] === 'Bearer'
  ) {
    req.authToken = req.headers.authorization.split(' ')[1];
  } else {
    req.authToken = null;
  }
  next();
};


export const checkIfAuthenticated = (req, res, next) => {
 getAuthToken(req, res, async () => {
    try {
      const { authToken } = req;
      const userInfo = await admin
        .auth()
        .verifyIdToken(authToken);
      req.authId = userInfo.uid;
      return next();
    } catch (e) {
      return res
        .status(401)
        .send({ error: 'You are not authorized to make this request' });
    }
  });
}; */