class AxiosClient {
  constructor(baseURL){
    this.baseURL = baseURL
      // this.client = this.$axios.create({
      //   headers: {
      //     "Content-Type": "application/json",
      //     "Access-Control-Allow-Origin": "*"
      //   },
      //   timeout : 5000
      // })
  }

  async post(data) {
    try {
      const response =  await this.$axios.post(this.baseURL, data);
      return response;
    }catch(error) {
      throw error;
    }
  }

  async get(params) {
    try{
      const response = await this.$axios.get(this.baseURL, {params: params});
      return response;
    }catch(error){
      throw error;
    }
  }
}

export default AxiosClient;
