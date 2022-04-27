import CustomApi from "./custom-api";

const baseURL = "/cate"

const getDispCateList = async () => {
  const {data} = await CustomApi.get(baseURL + "/dispCate");
  return data;
}

export default {
  getDispCateList,
}
