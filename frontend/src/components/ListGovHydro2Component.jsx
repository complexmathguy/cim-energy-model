import React, { Component } from 'react'
import GovHydro2Service from '../services/GovHydro2Service'

class ListGovHydro2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro2s: []
        }
        this.addGovHydro2 = this.addGovHydro2.bind(this);
        this.editGovHydro2 = this.editGovHydro2.bind(this);
        this.deleteGovHydro2 = this.deleteGovHydro2.bind(this);
    }

    deleteGovHydro2(id){
        GovHydro2Service.deleteGovHydro2(id).then( res => {
            this.setState({govHydro2s: this.state.govHydro2s.filter(govHydro2 => govHydro2.govHydro2Id !== id)});
        });
    }
    viewGovHydro2(id){
        this.props.history.push(`/view-govHydro2/${id}`);
    }
    editGovHydro2(id){
        this.props.history.push(`/add-govHydro2/${id}`);
    }

    componentDidMount(){
        GovHydro2Service.getGovHydro2s().then((res) => {
            this.setState({ govHydro2s: res.data});
        });
    }

    addGovHydro2(){
        this.props.history.push('/add-govHydro2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro2}> Add GovHydro2</button>
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
                                    this.state.govHydro2s.map(
                                        govHydro2 => 
                                        <tr key = {govHydro2.govHydro2Id}>
                                             <td> { govHydro2.aturb } </td>
                                             <td> { govHydro2.bturb } </td>
                                             <td> { govHydro2.db1 } </td>
                                             <td> { govHydro2.db2 } </td>
                                             <td> { govHydro2.eps } </td>
                                             <td> { govHydro2.gv1 } </td>
                                             <td> { govHydro2.gv2 } </td>
                                             <td> { govHydro2.gv3 } </td>
                                             <td> { govHydro2.gv4 } </td>
                                             <td> { govHydro2.gv5 } </td>
                                             <td> { govHydro2.gv6 } </td>
                                             <td> { govHydro2.kturb } </td>
                                             <td> { govHydro2.mwbase } </td>
                                             <td> { govHydro2.pgv1 } </td>
                                             <td> { govHydro2.pgv2 } </td>
                                             <td> { govHydro2.pgv3 } </td>
                                             <td> { govHydro2.pgv4 } </td>
                                             <td> { govHydro2.pgv5 } </td>
                                             <td> { govHydro2.pgv6 } </td>
                                             <td> { govHydro2.pmax } </td>
                                             <td> { govHydro2.pmin } </td>
                                             <td> { govHydro2.rperm } </td>
                                             <td> { govHydro2.rtemp } </td>
                                             <td> { govHydro2.tg } </td>
                                             <td> { govHydro2.tp } </td>
                                             <td> { govHydro2.tr } </td>
                                             <td> { govHydro2.tw } </td>
                                             <td> { govHydro2.uc } </td>
                                             <td> { govHydro2.uo } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro2(govHydro2.govHydro2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro2(govHydro2.govHydro2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro2(govHydro2.govHydro2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro2Component
