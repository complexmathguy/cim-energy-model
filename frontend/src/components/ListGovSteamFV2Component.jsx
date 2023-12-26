import React, { Component } from 'react'
import GovSteamFV2Service from '../services/GovSteamFV2Service'

class ListGovSteamFV2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamFV2s: []
        }
        this.addGovSteamFV2 = this.addGovSteamFV2.bind(this);
        this.editGovSteamFV2 = this.editGovSteamFV2.bind(this);
        this.deleteGovSteamFV2 = this.deleteGovSteamFV2.bind(this);
    }

    deleteGovSteamFV2(id){
        GovSteamFV2Service.deleteGovSteamFV2(id).then( res => {
            this.setState({govSteamFV2s: this.state.govSteamFV2s.filter(govSteamFV2 => govSteamFV2.govSteamFV2Id !== id)});
        });
    }
    viewGovSteamFV2(id){
        this.props.history.push(`/view-govSteamFV2/${id}`);
    }
    editGovSteamFV2(id){
        this.props.history.push(`/add-govSteamFV2/${id}`);
    }

    componentDidMount(){
        GovSteamFV2Service.getGovSteamFV2s().then((res) => {
            this.setState({ govSteamFV2s: res.data});
        });
    }

    addGovSteamFV2(){
        this.props.history.push('/add-govSteamFV2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamFV2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamFV2}> Add GovSteamFV2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Dt </th>
                                    <th> K </th>
                                    <th> Mwbase </th>
                                    <th> R </th>
                                    <th> T1 </th>
                                    <th> T3 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Ti </th>
                                    <th> Tt </th>
                                    <th> Vmax </th>
                                    <th> Vmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govSteamFV2s.map(
                                        govSteamFV2 => 
                                        <tr key = {govSteamFV2.govSteamFV2Id}>
                                             <td> { govSteamFV2.dt } </td>
                                             <td> { govSteamFV2.k } </td>
                                             <td> { govSteamFV2.mwbase } </td>
                                             <td> { govSteamFV2.r } </td>
                                             <td> { govSteamFV2.t1 } </td>
                                             <td> { govSteamFV2.t3 } </td>
                                             <td> { govSteamFV2.ta } </td>
                                             <td> { govSteamFV2.tb } </td>
                                             <td> { govSteamFV2.tc } </td>
                                             <td> { govSteamFV2.ti } </td>
                                             <td> { govSteamFV2.tt } </td>
                                             <td> { govSteamFV2.vmax } </td>
                                             <td> { govSteamFV2.vmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamFV2(govSteamFV2.govSteamFV2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamFV2(govSteamFV2.govSteamFV2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamFV2(govSteamFV2.govSteamFV2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamFV2Component
