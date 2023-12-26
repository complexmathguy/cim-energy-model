import React, { Component } from 'react'
import GovHydroPIDService from '../services/GovHydroPIDService'

class ListGovHydroPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroPIDs: []
        }
        this.addGovHydroPID = this.addGovHydroPID.bind(this);
        this.editGovHydroPID = this.editGovHydroPID.bind(this);
        this.deleteGovHydroPID = this.deleteGovHydroPID.bind(this);
    }

    deleteGovHydroPID(id){
        GovHydroPIDService.deleteGovHydroPID(id).then( res => {
            this.setState({govHydroPIDs: this.state.govHydroPIDs.filter(govHydroPID => govHydroPID.govHydroPIDId !== id)});
        });
    }
    viewGovHydroPID(id){
        this.props.history.push(`/view-govHydroPID/${id}`);
    }
    editGovHydroPID(id){
        this.props.history.push(`/add-govHydroPID/${id}`);
    }

    componentDidMount(){
        GovHydroPIDService.getGovHydroPIDs().then((res) => {
            this.setState({ govHydroPIDs: res.data});
        });
    }

    addGovHydroPID(){
        this.props.history.push('/add-govHydroPID/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroPID List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroPID}> Add GovHydroPID</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Aturb </th>
                                    <th> Bturb </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Eps </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> InputSignal </th>
                                    <th> Kd </th>
                                    <th> Kg </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Mwbase </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pgv4 </th>
                                    <th> Pgv5 </th>
                                    <th> Pgv6 </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> R </th>
                                    <th> Td </th>
                                    <th> Tf </th>
                                    <th> Tp </th>
                                    <th> Tt </th>
                                    <th> Tturb </th>
                                    <th> Velcl </th>
                                    <th> Velop </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroPIDs.map(
                                        govHydroPID => 
                                        <tr key = {govHydroPID.govHydroPIDId}>
                                             <td> { govHydroPID.aturb } </td>
                                             <td> { govHydroPID.bturb } </td>
                                             <td> { govHydroPID.db1 } </td>
                                             <td> { govHydroPID.db2 } </td>
                                             <td> { govHydroPID.eps } </td>
                                             <td> { govHydroPID.gv1 } </td>
                                             <td> { govHydroPID.gv2 } </td>
                                             <td> { govHydroPID.gv3 } </td>
                                             <td> { govHydroPID.gv4 } </td>
                                             <td> { govHydroPID.gv5 } </td>
                                             <td> { govHydroPID.gv6 } </td>
                                             <td> { govHydroPID.inputSignal } </td>
                                             <td> { govHydroPID.kd } </td>
                                             <td> { govHydroPID.kg } </td>
                                             <td> { govHydroPID.ki } </td>
                                             <td> { govHydroPID.kp } </td>
                                             <td> { govHydroPID.mwbase } </td>
                                             <td> { govHydroPID.pgv1 } </td>
                                             <td> { govHydroPID.pgv2 } </td>
                                             <td> { govHydroPID.pgv3 } </td>
                                             <td> { govHydroPID.pgv4 } </td>
                                             <td> { govHydroPID.pgv5 } </td>
                                             <td> { govHydroPID.pgv6 } </td>
                                             <td> { govHydroPID.pmax } </td>
                                             <td> { govHydroPID.pmin } </td>
                                             <td> { govHydroPID.r } </td>
                                             <td> { govHydroPID.td } </td>
                                             <td> { govHydroPID.tf } </td>
                                             <td> { govHydroPID.tp } </td>
                                             <td> { govHydroPID.tt } </td>
                                             <td> { govHydroPID.tturb } </td>
                                             <td> { govHydroPID.velcl } </td>
                                             <td> { govHydroPID.velop } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroPID(govHydroPID.govHydroPIDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroPID(govHydroPID.govHydroPIDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroPID(govHydroPID.govHydroPIDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroPIDComponent
