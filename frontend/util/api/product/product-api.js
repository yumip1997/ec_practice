import CustomApi from "../custom-api";

const baseURL = "/prd";

const getPrdListByCate = async (cateId) => {
  const {data} = await CustomApi.get(baseURL + "/list" , {cateId : cateId} );
  return data;
}

export default {
  getPrdListByCate
}
