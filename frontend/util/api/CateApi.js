import AxiosClient from "./AxiosClient";

class CateApi {
  constructor(){
    this.client = new AxiosClient('/api/cate')
  }

  async getDispCateList(){
    const dispCateList = await this.client.get(this.client.baseURL + "/dispCate");
    return dispCateList.data;
  }
}

const instance = new CateApi();

export default instance;
