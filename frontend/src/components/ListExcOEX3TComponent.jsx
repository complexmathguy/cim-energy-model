import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService'

class ListExcOEX3TComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excOEX3Ts: []
        }
        this.addExcOEX3T = this.addExcOEX3T.bind(this);
        this.editExcOEX3T = this.editExcOEX3T.bind(this);
        this.deleteExcOEX3T = this.deleteExcOEX3T.bind(this);
    }

    deleteExcOEX3T(id){
        ExcOEX3TService.deleteExcOEX3T(id).then( res => {
            this.setState({excOEX3Ts: this.state.excOEX3Ts.filter(excOEX3T => excOEX3T.excOEX3TId !== id)});
        });
    }
    viewExcOEX3T(id){
        this.props.history.push(`/view-excOEX3T/${id}`);
    }
    editExcOEX3T(id){
        this.props.history.push(`/add-excOEX3T/${id}`);
    }

    componentDidMount(){
        ExcOEX3TService.getExcOEX3Ts().then((res) => {
            this.setState({ excOEX3Ts: res.data});
        });
    }

    addExcOEX3T(){
        this.props.history.push('/add-excOEX3T/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcOEX3T List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcOEX3T}> Add ExcOEX3T</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> E1 </th>
                                    <th> E2 </th>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> See1 </th>
                                    <th> See2 </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excOEX3Ts.map(
                                        excOEX3T => 
                                        <tr key = {excOEX3T.excOEX3TId}>
                                             <td> { excOEX3T.e1 } </td>
                                             <td> { excOEX3T.e2 } </td>
                                             <td> { excOEX3T.ka } </td>
                                             <td> { excOEX3T.kc } </td>
                                             <td> { excOEX3T.kd } </td>
                                             <td> { excOEX3T.ke } </td>
                                             <td> { excOEX3T.kf } </td>
                                             <td> { excOEX3T.see1 } </td>
                                             <td> { excOEX3T.see2 } </td>
                                             <td> { excOEX3T.t1 } </td>
                                             <td> { excOEX3T.t2 } </td>
                                             <td> { excOEX3T.t3 } </td>
                                             <td> { excOEX3T.t4 } </td>
                                             <td> { excOEX3T.t5 } </td>
                                             <td> { excOEX3T.t6 } </td>
                                             <td> { excOEX3T.te } </td>
                                             <td> { excOEX3T.tf } </td>
                                             <td> { excOEX3T.vrmax } </td>
                                             <td> { excOEX3T.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcOEX3T(excOEX3T.excOEX3TId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcOEX3T(excOEX3T.excOEX3TId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcOEX3T(excOEX3T.excOEX3TId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcOEX3TComponent
