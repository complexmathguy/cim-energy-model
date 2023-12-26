import React, { Component } from 'react'
import GovGAST3Service from '../services/GovGAST3Service'

class ListGovGAST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGAST3s: []
        }
        this.addGovGAST3 = this.addGovGAST3.bind(this);
        this.editGovGAST3 = this.editGovGAST3.bind(this);
        this.deleteGovGAST3 = this.deleteGovGAST3.bind(this);
    }

    deleteGovGAST3(id){
        GovGAST3Service.deleteGovGAST3(id).then( res => {
            this.setState({govGAST3s: this.state.govGAST3s.filter(govGAST3 => govGAST3.govGAST3Id !== id)});
        });
    }
    viewGovGAST3(id){
        this.props.history.push(`/view-govGAST3/${id}`);
    }
    editGovGAST3(id){
        this.props.history.push(`/add-govGAST3/${id}`);
    }

    componentDidMount(){
        GovGAST3Service.getGovGAST3s().then((res) => {
            this.setState({ govGAST3s: res.data});
        });
    }

    addGovGAST3(){
        this.props.history.push('/add-govGAST3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST3}> Add GovGAST3</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Bca </th>
                                    <th> Bp </th>
                                    <th> Dtc </th>
                                    <th> Ka </th>
                                    <th> Kac </th>
                                    <th> Kca </th>
                                    <th> Ksi </th>
                                    <th> Ky </th>
                                    <th> Mnef </th>
                                    <th> Mxef </th>
                                    <th> Rcmn </th>
                                    <th> Rcmx </th>
                                    <th> Tac </th>
                                    <th> Tc </th>
                                    <th> Td </th>
                                    <th> Tfen </th>
                                    <th> Tg </th>
                                    <th> Tsi </th>
                                    <th> Tt </th>
                                    <th> Ttc </th>
                                    <th> Ty </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govGAST3s.map(
                                        govGAST3 => 
                                        <tr key = {govGAST3.govGAST3Id}>
                                             <td> { govGAST3.bca } </td>
                                             <td> { govGAST3.bp } </td>
                                             <td> { govGAST3.dtc } </td>
                                             <td> { govGAST3.ka } </td>
                                             <td> { govGAST3.kac } </td>
                                             <td> { govGAST3.kca } </td>
                                             <td> { govGAST3.ksi } </td>
                                             <td> { govGAST3.ky } </td>
                                             <td> { govGAST3.mnef } </td>
                                             <td> { govGAST3.mxef } </td>
                                             <td> { govGAST3.rcmn } </td>
                                             <td> { govGAST3.rcmx } </td>
                                             <td> { govGAST3.tac } </td>
                                             <td> { govGAST3.tc } </td>
                                             <td> { govGAST3.td } </td>
                                             <td> { govGAST3.tfen } </td>
                                             <td> { govGAST3.tg } </td>
                                             <td> { govGAST3.tsi } </td>
                                             <td> { govGAST3.tt } </td>
                                             <td> { govGAST3.ttc } </td>
                                             <td> { govGAST3.ty } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST3(govGAST3.govGAST3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST3(govGAST3.govGAST3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST3(govGAST3.govGAST3Id)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListGovGAST3Component
