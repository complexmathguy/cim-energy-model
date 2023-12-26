import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service'

class ListGovHydro4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro4s: []
        }
        this.addGovHydro4 = this.addGovHydro4.bind(this);
        this.editGovHydro4 = this.editGovHydro4.bind(this);
        this.deleteGovHydro4 = this.deleteGovHydro4.bind(this);
    }

    deleteGovHydro4(id){
        GovHydro4Service.deleteGovHydro4(id).then( res => {
            this.setState({govHydro4s: this.state.govHydro4s.filter(govHydro4 => govHydro4.govHydro4Id !== id)});
        });
    }
    viewGovHydro4(id){
        this.props.history.push(`/view-govHydro4/${id}`);
    }
    editGovHydro4(id){
        this.props.history.push(`/add-govHydro4/${id}`);
    }

    componentDidMount(){
        GovHydro4Service.getGovHydro4s().then((res) => {
            this.setState({ govHydro4s: res.data});
        });
    }

    addGovHydro4(){
        this.props.history.push('/add-govHydro4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro4}> Add GovHydro4</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> At </th>
                                    <th> Bgv0 </th>
                                    <th> Bgv1 </th>
                                    <th> Bgv2 </th>
                                    <th> Bgv3 </th>
                                    <th> Bgv4 </th>
                                    <th> Bgv5 </th>
                                    <th> Bmax </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Dturb </th>
                                    <th> Eps </th>
                                    <th> Gmax </th>
                                    <th> Gmin </th>
                                    <th> Gv0 </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Hdam </th>
                                    <th> Mwbase </th>
                                    <th> Pgv0 </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pgv4 </th>
                                    <th> Pgv5 </th>
                                    <th> Qn1 </th>
                                    <th> Rperm </th>
                                    <th> Rtemp </th>
                                    <th> Tblade </th>
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
                                    this.state.govHydro4s.map(
                                        govHydro4 => 
                                        <tr key = {govHydro4.govHydro4Id}>
                                             <td> { govHydro4.at } </td>
                                             <td> { govHydro4.bgv0 } </td>
                                             <td> { govHydro4.bgv1 } </td>
                                             <td> { govHydro4.bgv2 } </td>
                                             <td> { govHydro4.bgv3 } </td>
                                             <td> { govHydro4.bgv4 } </td>
                                             <td> { govHydro4.bgv5 } </td>
                                             <td> { govHydro4.bmax } </td>
                                             <td> { govHydro4.db1 } </td>
                                             <td> { govHydro4.db2 } </td>
                                             <td> { govHydro4.dturb } </td>
                                             <td> { govHydro4.eps } </td>
                                             <td> { govHydro4.gmax } </td>
                                             <td> { govHydro4.gmin } </td>
                                             <td> { govHydro4.gv0 } </td>
                                             <td> { govHydro4.gv1 } </td>
                                             <td> { govHydro4.gv2 } </td>
                                             <td> { govHydro4.gv3 } </td>
                                             <td> { govHydro4.gv4 } </td>
                                             <td> { govHydro4.gv5 } </td>
                                             <td> { govHydro4.hdam } </td>
                                             <td> { govHydro4.mwbase } </td>
                                             <td> { govHydro4.pgv0 } </td>
                                             <td> { govHydro4.pgv1 } </td>
                                             <td> { govHydro4.pgv2 } </td>
                                             <td> { govHydro4.pgv3 } </td>
                                             <td> { govHydro4.pgv4 } </td>
                                             <td> { govHydro4.pgv5 } </td>
                                             <td> { govHydro4.qn1 } </td>
                                             <td> { govHydro4.rperm } </td>
                                             <td> { govHydro4.rtemp } </td>
                                             <td> { govHydro4.tblade } </td>
                                             <td> { govHydro4.tg } </td>
                                             <td> { govHydro4.tp } </td>
                                             <td> { govHydro4.tr } </td>
                                             <td> { govHydro4.tw } </td>
                                             <td> { govHydro4.uc } </td>
                                             <td> { govHydro4.uo } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro4(govHydro4.govHydro4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro4(govHydro4.govHydro4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro4(govHydro4.govHydro4Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro4Component
