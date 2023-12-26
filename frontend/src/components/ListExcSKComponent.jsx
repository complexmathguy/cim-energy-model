import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService'

class ListExcSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excSKs: []
        }
        this.addExcSK = this.addExcSK.bind(this);
        this.editExcSK = this.editExcSK.bind(this);
        this.deleteExcSK = this.deleteExcSK.bind(this);
    }

    deleteExcSK(id){
        ExcSKService.deleteExcSK(id).then( res => {
            this.setState({excSKs: this.state.excSKs.filter(excSK => excSK.excSKId !== id)});
        });
    }
    viewExcSK(id){
        this.props.history.push(`/view-excSK/${id}`);
    }
    editExcSK(id){
        this.props.history.push(`/add-excSK/${id}`);
    }

    componentDidMount(){
        ExcSKService.getExcSKs().then((res) => {
            this.setState({ excSKs: res.data});
        });
    }

    addExcSK(){
        this.props.history.push('/add-excSK/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcSK List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcSK}> Add ExcSK</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdmax </th>
                                    <th> Efdmin </th>
                                    <th> Emax </th>
                                    <th> Emin </th>
                                    <th> K </th>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> Kc </th>
                                    <th> Kce </th>
                                    <th> Kd </th>
                                    <th> Kgob </th>
                                    <th> Kp </th>
                                    <th> Kqi </th>
                                    <th> Kqob </th>
                                    <th> Kqp </th>
                                    <th> Nq </th>
                                    <th> Qconoff </th>
                                    <th> Qz </th>
                                    <th> Remote </th>
                                    <th> Sbase </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Ti </th>
                                    <th> Tp </th>
                                    <th> Tr </th>
                                    <th> Uimax </th>
                                    <th> Uimin </th>
                                    <th> Urmax </th>
                                    <th> Urmin </th>
                                    <th> Vtmax </th>
                                    <th> Vtmin </th>
                                    <th> Yp </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excSKs.map(
                                        excSK => 
                                        <tr key = {excSK.excSKId}>
                                             <td> { excSK.efdmax } </td>
                                             <td> { excSK.efdmin } </td>
                                             <td> { excSK.emax } </td>
                                             <td> { excSK.emin } </td>
                                             <td> { excSK.k } </td>
                                             <td> { excSK.k1 } </td>
                                             <td> { excSK.k2 } </td>
                                             <td> { excSK.kc } </td>
                                             <td> { excSK.kce } </td>
                                             <td> { excSK.kd } </td>
                                             <td> { excSK.kgob } </td>
                                             <td> { excSK.kp } </td>
                                             <td> { excSK.kqi } </td>
                                             <td> { excSK.kqob } </td>
                                             <td> { excSK.kqp } </td>
                                             <td> { excSK.nq } </td>
                                             <td> { excSK.qconoff } </td>
                                             <td> { excSK.qz } </td>
                                             <td> { excSK.remote } </td>
                                             <td> { excSK.sbase } </td>
                                             <td> { excSK.tc } </td>
                                             <td> { excSK.te } </td>
                                             <td> { excSK.ti } </td>
                                             <td> { excSK.tp } </td>
                                             <td> { excSK.tr } </td>
                                             <td> { excSK.uimax } </td>
                                             <td> { excSK.uimin } </td>
                                             <td> { excSK.urmax } </td>
                                             <td> { excSK.urmin } </td>
                                             <td> { excSK.vtmax } </td>
                                             <td> { excSK.vtmin } </td>
                                             <td> { excSK.yp } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcSK(excSK.excSKId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcSK(excSK.excSKId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcSK(excSK.excSKId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcSKComponent
