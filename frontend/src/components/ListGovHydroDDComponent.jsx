import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService'

class ListGovHydroDDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroDDs: []
        }
        this.addGovHydroDD = this.addGovHydroDD.bind(this);
        this.editGovHydroDD = this.editGovHydroDD.bind(this);
        this.deleteGovHydroDD = this.deleteGovHydroDD.bind(this);
    }

    deleteGovHydroDD(id){
        GovHydroDDService.deleteGovHydroDD(id).then( res => {
            this.setState({govHydroDDs: this.state.govHydroDDs.filter(govHydroDD => govHydroDD.govHydroDDId !== id)});
        });
    }
    viewGovHydroDD(id){
        this.props.history.push(`/view-govHydroDD/${id}`);
    }
    editGovHydroDD(id){
        this.props.history.push(`/add-govHydroDD/${id}`);
    }

    componentDidMount(){
        GovHydroDDService.getGovHydroDDs().then((res) => {
            this.setState({ govHydroDDs: res.data});
        });
    }

    addGovHydroDD(){
        this.props.history.push('/add-govHydroDD/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroDD List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroDD}> Add GovHydroDD</button>
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
                                    <th> Gmax </th>
                                    <th> Gmin </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> InputSignal </th>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> Kg </th>
                                    <th> Ki </th>
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
                                    this.state.govHydroDDs.map(
                                        govHydroDD => 
                                        <tr key = {govHydroDD.govHydroDDId}>
                                             <td> { govHydroDD.aturb } </td>
                                             <td> { govHydroDD.bturb } </td>
                                             <td> { govHydroDD.db1 } </td>
                                             <td> { govHydroDD.db2 } </td>
                                             <td> { govHydroDD.eps } </td>
                                             <td> { govHydroDD.gmax } </td>
                                             <td> { govHydroDD.gmin } </td>
                                             <td> { govHydroDD.gv1 } </td>
                                             <td> { govHydroDD.gv2 } </td>
                                             <td> { govHydroDD.gv3 } </td>
                                             <td> { govHydroDD.gv4 } </td>
                                             <td> { govHydroDD.gv5 } </td>
                                             <td> { govHydroDD.gv6 } </td>
                                             <td> { govHydroDD.inputSignal } </td>
                                             <td> { govHydroDD.k1 } </td>
                                             <td> { govHydroDD.k2 } </td>
                                             <td> { govHydroDD.kg } </td>
                                             <td> { govHydroDD.ki } </td>
                                             <td> { govHydroDD.mwbase } </td>
                                             <td> { govHydroDD.pgv1 } </td>
                                             <td> { govHydroDD.pgv2 } </td>
                                             <td> { govHydroDD.pgv3 } </td>
                                             <td> { govHydroDD.pgv4 } </td>
                                             <td> { govHydroDD.pgv5 } </td>
                                             <td> { govHydroDD.pgv6 } </td>
                                             <td> { govHydroDD.pmax } </td>
                                             <td> { govHydroDD.pmin } </td>
                                             <td> { govHydroDD.r } </td>
                                             <td> { govHydroDD.td } </td>
                                             <td> { govHydroDD.tf } </td>
                                             <td> { govHydroDD.tp } </td>
                                             <td> { govHydroDD.tt } </td>
                                             <td> { govHydroDD.tturb } </td>
                                             <td> { govHydroDD.velcl } </td>
                                             <td> { govHydroDD.velop } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroDD(govHydroDD.govHydroDDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroDD(govHydroDD.govHydroDDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroDD(govHydroDD.govHydroDDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroDDComponent
