import React, { Component } from 'react'
import GovHydroIEEE0Service from '../services/GovHydroIEEE0Service'

class ListGovHydroIEEE0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroIEEE0s: []
        }
        this.addGovHydroIEEE0 = this.addGovHydroIEEE0.bind(this);
        this.editGovHydroIEEE0 = this.editGovHydroIEEE0.bind(this);
        this.deleteGovHydroIEEE0 = this.deleteGovHydroIEEE0.bind(this);
    }

    deleteGovHydroIEEE0(id){
        GovHydroIEEE0Service.deleteGovHydroIEEE0(id).then( res => {
            this.setState({govHydroIEEE0s: this.state.govHydroIEEE0s.filter(govHydroIEEE0 => govHydroIEEE0.govHydroIEEE0Id !== id)});
        });
    }
    viewGovHydroIEEE0(id){
        this.props.history.push(`/view-govHydroIEEE0/${id}`);
    }
    editGovHydroIEEE0(id){
        this.props.history.push(`/add-govHydroIEEE0/${id}`);
    }

    componentDidMount(){
        GovHydroIEEE0Service.getGovHydroIEEE0s().then((res) => {
            this.setState({ govHydroIEEE0s: res.data});
        });
    }

    addGovHydroIEEE0(){
        this.props.history.push('/add-govHydroIEEE0/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroIEEE0 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroIEEE0}> Add GovHydroIEEE0</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> K </th>
                                    <th> Mwbase </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroIEEE0s.map(
                                        govHydroIEEE0 => 
                                        <tr key = {govHydroIEEE0.govHydroIEEE0Id}>
                                             <td> { govHydroIEEE0.k } </td>
                                             <td> { govHydroIEEE0.mwbase } </td>
                                             <td> { govHydroIEEE0.pmax } </td>
                                             <td> { govHydroIEEE0.pmin } </td>
                                             <td> { govHydroIEEE0.t1 } </td>
                                             <td> { govHydroIEEE0.t2 } </td>
                                             <td> { govHydroIEEE0.t3 } </td>
                                             <td> { govHydroIEEE0.t4 } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroIEEE0(govHydroIEEE0.govHydroIEEE0Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroIEEE0(govHydroIEEE0.govHydroIEEE0Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroIEEE0(govHydroIEEE0.govHydroIEEE0Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroIEEE0Component
