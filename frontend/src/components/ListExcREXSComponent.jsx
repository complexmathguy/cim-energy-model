import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService'

class ListExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excREXSs: []
        }
        this.addExcREXS = this.addExcREXS.bind(this);
        this.editExcREXS = this.editExcREXS.bind(this);
        this.deleteExcREXS = this.deleteExcREXS.bind(this);
    }

    deleteExcREXS(id){
        ExcREXSService.deleteExcREXS(id).then( res => {
            this.setState({excREXSs: this.state.excREXSs.filter(excREXS => excREXS.excREXSId !== id)});
        });
    }
    viewExcREXS(id){
        this.props.history.push(`/view-excREXS/${id}`);
    }
    editExcREXS(id){
        this.props.history.push(`/add-excREXS/${id}`);
    }

    componentDidMount(){
        ExcREXSService.getExcREXSs().then((res) => {
            this.setState({ excREXSs: res.data});
        });
    }

    addExcREXS(){
        this.props.history.push('/add-excREXS/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcREXS List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcREXS}> Add ExcREXS</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> E1 </th>
                                    <th> E2 </th>
                                    <th> Fbf </th>
                                    <th> Flimf </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kefd </th>
                                    <th> Kf </th>
                                    <th> Kh </th>
                                    <th> Kii </th>
                                    <th> Kip </th>
                                    <th> Ks </th>
                                    <th> Kvi </th>
                                    <th> Kvp </th>
                                    <th> Kvphz </th>
                                    <th> Nvphz </th>
                                    <th> Se1 </th>
                                    <th> Se2 </th>
                                    <th> Ta </th>
                                    <th> Tb1 </th>
                                    <th> Tb2 </th>
                                    <th> Tc1 </th>
                                    <th> Tc2 </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Tf1 </th>
                                    <th> Tf2 </th>
                                    <th> Tp </th>
                                    <th> Vcmax </th>
                                    <th> Vfmax </th>
                                    <th> Vfmin </th>
                                    <th> Vimax </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Xc </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excREXSs.map(
                                        excREXS => 
                                        <tr key = {excREXS.excREXSId}>
                                             <td> { excREXS.e1 } </td>
                                             <td> { excREXS.e2 } </td>
                                             <td> { excREXS.fbf } </td>
                                             <td> { excREXS.flimf } </td>
                                             <td> { excREXS.kc } </td>
                                             <td> { excREXS.kd } </td>
                                             <td> { excREXS.ke } </td>
                                             <td> { excREXS.kefd } </td>
                                             <td> { excREXS.kf } </td>
                                             <td> { excREXS.kh } </td>
                                             <td> { excREXS.kii } </td>
                                             <td> { excREXS.kip } </td>
                                             <td> { excREXS.ks } </td>
                                             <td> { excREXS.kvi } </td>
                                             <td> { excREXS.kvp } </td>
                                             <td> { excREXS.kvphz } </td>
                                             <td> { excREXS.nvphz } </td>
                                             <td> { excREXS.se1 } </td>
                                             <td> { excREXS.se2 } </td>
                                             <td> { excREXS.ta } </td>
                                             <td> { excREXS.tb1 } </td>
                                             <td> { excREXS.tb2 } </td>
                                             <td> { excREXS.tc1 } </td>
                                             <td> { excREXS.tc2 } </td>
                                             <td> { excREXS.te } </td>
                                             <td> { excREXS.tf } </td>
                                             <td> { excREXS.tf1 } </td>
                                             <td> { excREXS.tf2 } </td>
                                             <td> { excREXS.tp } </td>
                                             <td> { excREXS.vcmax } </td>
                                             <td> { excREXS.vfmax } </td>
                                             <td> { excREXS.vfmin } </td>
                                             <td> { excREXS.vimax } </td>
                                             <td> { excREXS.vrmax } </td>
                                             <td> { excREXS.vrmin } </td>
                                             <td> { excREXS.xc } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcREXS(excREXS.excREXSId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcREXS(excREXS.excREXSId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcREXS(excREXS.excREXSId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcREXSComponent
