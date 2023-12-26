import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service'

class ListGovSteamIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamIEEE1s: []
        }
        this.addGovSteamIEEE1 = this.addGovSteamIEEE1.bind(this);
        this.editGovSteamIEEE1 = this.editGovSteamIEEE1.bind(this);
        this.deleteGovSteamIEEE1 = this.deleteGovSteamIEEE1.bind(this);
    }

    deleteGovSteamIEEE1(id){
        GovSteamIEEE1Service.deleteGovSteamIEEE1(id).then( res => {
            this.setState({govSteamIEEE1s: this.state.govSteamIEEE1s.filter(govSteamIEEE1 => govSteamIEEE1.govSteamIEEE1Id !== id)});
        });
    }
    viewGovSteamIEEE1(id){
        this.props.history.push(`/view-govSteamIEEE1/${id}`);
    }
    editGovSteamIEEE1(id){
        this.props.history.push(`/add-govSteamIEEE1/${id}`);
    }

    componentDidMount(){
        GovSteamIEEE1Service.getGovSteamIEEE1s().then((res) => {
            this.setState({ govSteamIEEE1s: res.data});
        });
    }

    addGovSteamIEEE1(){
        this.props.history.push('/add-govSteamIEEE1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamIEEE1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamIEEE1}> Add GovSteamIEEE1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> K </th>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> K3 </th>
                                    <th> K4 </th>
                                    <th> K5 </th>
                                    <th> K6 </th>
                                    <th> K7 </th>
                                    <th> K8 </th>
                                    <th> Mwbase </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> T7 </th>
                                    <th> Uc </th>
                                    <th> Uo </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govSteamIEEE1s.map(
                                        govSteamIEEE1 => 
                                        <tr key = {govSteamIEEE1.govSteamIEEE1Id}>
                                             <td> { govSteamIEEE1.k } </td>
                                             <td> { govSteamIEEE1.k1 } </td>
                                             <td> { govSteamIEEE1.k2 } </td>
                                             <td> { govSteamIEEE1.k3 } </td>
                                             <td> { govSteamIEEE1.k4 } </td>
                                             <td> { govSteamIEEE1.k5 } </td>
                                             <td> { govSteamIEEE1.k6 } </td>
                                             <td> { govSteamIEEE1.k7 } </td>
                                             <td> { govSteamIEEE1.k8 } </td>
                                             <td> { govSteamIEEE1.mwbase } </td>
                                             <td> { govSteamIEEE1.pmax } </td>
                                             <td> { govSteamIEEE1.pmin } </td>
                                             <td> { govSteamIEEE1.t1 } </td>
                                             <td> { govSteamIEEE1.t2 } </td>
                                             <td> { govSteamIEEE1.t3 } </td>
                                             <td> { govSteamIEEE1.t4 } </td>
                                             <td> { govSteamIEEE1.t5 } </td>
                                             <td> { govSteamIEEE1.t6 } </td>
                                             <td> { govSteamIEEE1.t7 } </td>
                                             <td> { govSteamIEEE1.uc } </td>
                                             <td> { govSteamIEEE1.uo } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamIEEE1(govSteamIEEE1.govSteamIEEE1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamIEEE1(govSteamIEEE1.govSteamIEEE1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamIEEE1(govSteamIEEE1.govSteamIEEE1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamIEEE1Component
