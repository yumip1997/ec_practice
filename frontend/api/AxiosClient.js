import axios from "axios";

class AxiosClient {
  constructor(baseURL){
    this.baseURL = baseURL
  }

  async post(url, data) {
    try {
      const response =  await axios.post(url, data);
      return response;
    }catch(error) {
      throw error;
    }
  }

  async get(url, params) {
    try{
      const response = await axios.get(url, {params: params});
      return response;
    }catch(error){
      throw error;
    }
  }
}

export default AxiosClient;
