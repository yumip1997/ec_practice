import CustomApi from "./custom-api";

const baseURL = "/prd";

const getPrdListByCate = async (cateId) => {
  const {data} = await CustomApi.get(baseURL + "/list");
  return data;
}

export default {
  getPrdListByCate
}
