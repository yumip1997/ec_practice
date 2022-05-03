import CustomApi from "../custom-api";

const baseURL = "/prd";

const getPrdDtl = async (prdId) => {
  const {data} = await CustomApi.get(baseURL , {prdId : prdId});
  return data;
}
const getPrdListByCate = async (cateId) => {
  const {data} = await CustomApi.get(baseURL + "/list" , {cateId : cateId} );
  return data;
}

export default {
  getPrdDtl,
  getPrdListByCate
}
