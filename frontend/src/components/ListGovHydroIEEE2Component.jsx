import React, { Component } from 'react'
import GovHydroIEEE2Service from '../services/GovHydroIEEE2Service'

class ListGovHydroIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroIEEE2s: []
        }
        this.addGovHydroIEEE2 = this.addGovHydroIEEE2.bind(this);
        this.editGovHydroIEEE2 = this.editGovHydroIEEE2.bind(this);
        this.deleteGovHydroIEEE2 = this.deleteGovHydroIEEE2.bind(this);
    }

    deleteGovHydroIEEE2(id){
        GovHydroIEEE2Service.deleteGovHydroIEEE2(id).then( res => {
            this.setState({govHydroIEEE2s: this.state.govHydroIEEE2s.filter(govHydroIEEE2 => govHydroIEEE2.govHydroIEEE2Id !== id)});
        });
    }
    viewGovHydroIEEE2(id){
        this.props.history.push(`/view-govHydroIEEE2/${id}`);
    }
    editGovHydroIEEE2(id){
        this.props.history.push(`/add-govHydroIEEE2/${id}`);
    }

    componentDidMount(){
        GovHydroIEEE2Service.getGovHydroIEEE2s().then((res) => {
            this.setState({ govHydroIEEE2s: res.data});
        });
    }

    addGovHydroIEEE2(){
        this.props.history.push('/add-govHydroIEEE2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroIEEE2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroIEEE2}> Add GovHydroIEEE2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Aturb </th>
                                    <th> Bturb </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> Kturb </th>
                                    <th> Mwbase </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pgv4 </th>
                                    <th> Pgv5 </th>
                                    <th> Pgv6 </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> Rperm </th>
                                    <th> Rtemp </th>
                                    <th> Tg </th>
                                    <th> Tp </th>
                                    <th> Tr </th>
                                    <th> Tw </th>
                                    <th> Uc </th>
                                    <th> Uo </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroIEEE2s.map(
                                        govHydroIEEE2 => 
                                        <tr key = {govHydroIEEE2.govHydroIEEE2Id}>
                                             <td> { govHydroIEEE2.aturb } </td>
                                             <td> { govHydroIEEE2.bturb } </td>
                                             <td> { govHydroIEEE2.gv1 } </td>
                                             <td> { govHydroIEEE2.gv2 } </td>
                                             <td> { govHydroIEEE2.gv3 } </td>
                                             <td> { govHydroIEEE2.gv4 } </td>
                                             <td> { govHydroIEEE2.gv5 } </td>
                                             <td> { govHydroIEEE2.gv6 } </td>
                                             <td> { govHydroIEEE2.kturb } </td>
                                             <td> { govHydroIEEE2.mwbase } </td>
                                             <td> { govHydroIEEE2.pgv1 } </td>
                                             <td> { govHydroIEEE2.pgv2 } </td>
                                             <td> { govHydroIEEE2.pgv3 } </td>
                                             <td> { govHydroIEEE2.pgv4 } </td>
                                             <td> { govHydroIEEE2.pgv5 } </td>
                                             <td> { govHydroIEEE2.pgv6 } </td>
                                             <td> { govHydroIEEE2.pmax } </td>
                                             <td> { govHydroIEEE2.pmin } </td>
                                             <td> { govHydroIEEE2.rperm } </td>
                                             <td> { govHydroIEEE2.rtemp } </td>
                                             <td> { govHydroIEEE2.tg } </td>
                                             <td> { govHydroIEEE2.tp } </td>
                                             <td> { govHydroIEEE2.tr } </td>
                                             <td> { govHydroIEEE2.tw } </td>
                                             <td> { govHydroIEEE2.uc } </td>
                                             <td> { govHydroIEEE2.uo } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroIEEE2(govHydroIEEE2.govHydroIEEE2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroIEEE2(govHydroIEEE2.govHydroIEEE2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroIEEE2(govHydroIEEE2.govHydroIEEE2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroIEEE2Component
