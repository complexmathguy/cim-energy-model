import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service'

class ListGovHydro3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro3s: []
        }
        this.addGovHydro3 = this.addGovHydro3.bind(this);
        this.editGovHydro3 = this.editGovHydro3.bind(this);
        this.deleteGovHydro3 = this.deleteGovHydro3.bind(this);
    }

    deleteGovHydro3(id){
        GovHydro3Service.deleteGovHydro3(id).then( res => {
            this.setState({govHydro3s: this.state.govHydro3s.filter(govHydro3 => govHydro3.govHydro3Id !== id)});
        });
    }
    viewGovHydro3(id){
        this.props.history.push(`/view-govHydro3/${id}`);
    }
    editGovHydro3(id){
        this.props.history.push(`/add-govHydro3/${id}`);
    }

    componentDidMount(){
        GovHydro3Service.getGovHydro3s().then((res) => {
            this.setState({ govHydro3s: res.data});
        });
    }

    addGovHydro3(){
        this.props.history.push('/add-govHydro3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro3}> Add GovHydro3</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> At </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Dturb </th>
                                    <th> Eps </th>
                                    <th> GovernorControl </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> H0 </th>
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
                                    <th> Qnl </th>
                                    <th> Relec </th>
                                    <th> Rgate </th>
                                    <th> Td </th>
                                    <th> Tf </th>
                                    <th> Tp </th>
                                    <th> Tt </th>
                                    <th> Tw </th>
                                    <th> Velcl </th>
                                    <th> Velop </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydro3s.map(
                                        govHydro3 => 
                                        <tr key = {govHydro3.govHydro3Id}>
                                             <td> { govHydro3.at } </td>
                                             <td> { govHydro3.db1 } </td>
                                             <td> { govHydro3.db2 } </td>
                                             <td> { govHydro3.dturb } </td>
                                             <td> { govHydro3.eps } </td>
                                             <td> { govHydro3.governorControl } </td>
                                             <td> { govHydro3.gv1 } </td>
                                             <td> { govHydro3.gv2 } </td>
                                             <td> { govHydro3.gv3 } </td>
                                             <td> { govHydro3.gv4 } </td>
                                             <td> { govHydro3.gv5 } </td>
                                             <td> { govHydro3.gv6 } </td>
                                             <td> { govHydro3.h0 } </td>
                                             <td> { govHydro3.k1 } </td>
                                             <td> { govHydro3.k2 } </td>
                                             <td> { govHydro3.kg } </td>
                                             <td> { govHydro3.ki } </td>
                                             <td> { govHydro3.mwbase } </td>
                                             <td> { govHydro3.pgv1 } </td>
                                             <td> { govHydro3.pgv2 } </td>
                                             <td> { govHydro3.pgv3 } </td>
                                             <td> { govHydro3.pgv4 } </td>
                                             <td> { govHydro3.pgv5 } </td>
                                             <td> { govHydro3.pgv6 } </td>
                                             <td> { govHydro3.pmax } </td>
                                             <td> { govHydro3.pmin } </td>
                                             <td> { govHydro3.qnl } </td>
                                             <td> { govHydro3.relec } </td>
                                             <td> { govHydro3.rgate } </td>
                                             <td> { govHydro3.td } </td>
                                             <td> { govHydro3.tf } </td>
                                             <td> { govHydro3.tp } </td>
                                             <td> { govHydro3.tt } </td>
                                             <td> { govHydro3.tw } </td>
                                             <td> { govHydro3.velcl } </td>
                                             <td> { govHydro3.velop } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro3(govHydro3.govHydro3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro3(govHydro3.govHydro3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro3(govHydro3.govHydro3Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro3Component
