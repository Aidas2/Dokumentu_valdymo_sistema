// import React, { Component } from "react";
// import axios from "axios";

// class RenderResponse extends Component {
//   state = {
//     documentId: null,
//     response: "",
//     file: "",
//     fileURL: ""
//   };

//   componentDidMount() {
//     // var uriPartToTheFileById = this.props.match.params.documentId;
//     axios({
//       url: "http://localhost:8081/files/view/",
//       method: "GET",
//       params: {
//         documentId: 2177
//       },
//       responseType: "blob" // important
//     })
//       .then(response => {
//         this.setState({ response });
//         const file = new Blob([response.data], { type: "application/pdf" });
//         this.setState({ file });
//         // const fileName = response.headers["content-disposition"].substring(
//         //   200,
//         //   22
//         // );

//         console.log("--------------- response >>>>>>>>> ", response);

//         // const url = window.URL.createObjectURL(
//         //   new Blob([response.data], { type: "application/octet-stream" }) //it works withoud a type as well
//         // );
//         // const link = document.createElement("a");
//         // link.href = url;
//         // link.setAttribute("download", fileName); //or any other extension
//         // document.body.appendChild(link);
//         // link.click();
//         // link.remove();
//       })
//       .catch(error => {
//         console.log(error);
//       });
//   }

//   render() {
//     return (
//       <div>
//         <p>Labas</p>

//         <object data={this.state.response} type="application/pdf" />
//       </div>
//     );
//   }
// }

// export default RenderResponse;
