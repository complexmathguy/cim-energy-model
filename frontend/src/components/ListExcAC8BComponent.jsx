import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService'

class ListExcAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC8Bs: []
        }
        this.addExcAC8B = this.addExcAC8B.bind(this);
        this.editExcAC8B = this.editExcAC8B.bind(this);
        this.deleteExcAC8B = this.deleteExcAC8B.bind(this);
    }

    deleteExcAC8B(id){
        ExcAC8BService.deleteExcAC8B(id).then( res => {
            this.setState({excAC8Bs: this.state.excAC8Bs.filter(excAC8B => excAC8B.excAC8BId !== id)});
        });
    }
    viewExcAC8B(id){
        this.props.history.push(`/view-excAC8B/${id}`);
    }
    editExcAC8B(id){
        this.props.history.push(`/add-excAC8B/${id}`);
    }

    componentDidMount(){
        ExcAC8BService.getExcAC8Bs().then((res) => {
            this.setState({ excAC8Bs: res.data});
        });
    }

    addExcAC8B(){
        this.props.history.push('/add-excAC8B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC8B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC8B}> Add ExcAC8B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Inlim </th>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Kdr </th>
                                    <th> Ke </th>
                                    <th> Kir </th>
                                    <th> Kpr </th>
                                    <th> Ks </th>
                                    <th> Pidlim </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Ta </th>
                                    <th> Tdr </th>
                                    <th> Te </th>
                                    <th> Telim </th>
                                    <th> Ve1 </th>
                                    <th> Ve2 </th>
                                    <th> Vemin </th>
                                    <th> Vfemax </th>
                                    <th> Vimax </th>
                                    <th> Vimin </th>
                                    <th> Vpidmax </th>
                                    <th> Vpidmin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Vtmult </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAC8Bs.map(
                                        excAC8B => 
                                        <tr key = {excAC8B.excAC8BId}>
                                             <td> { excAC8B.inlim } </td>
                                             <td> { excAC8B.ka } </td>
                                             <td> { excAC8B.kc } </td>
                                             <td> { excAC8B.kd } </td>
                                             <td> { excAC8B.kdr } </td>
                                             <td> { excAC8B.ke } </td>
                                             <td> { excAC8B.kir } </td>
                                             <td> { excAC8B.kpr } </td>
                                             <td> { excAC8B.ks } </td>
                                             <td> { excAC8B.pidlim } </td>
                                             <td> { excAC8B.seve1 } </td>
                                             <td> { excAC8B.seve2 } </td>
                                             <td> { excAC8B.ta } </td>
                                             <td> { excAC8B.tdr } </td>
                                             <td> { excAC8B.te } </td>
                                             <td> { excAC8B.telim } </td>
                                             <td> { excAC8B.ve1 } </td>
                                             <td> { excAC8B.ve2 } </td>
                                             <td> { excAC8B.vemin } </td>
                                             <td> { excAC8B.vfemax } </td>
                                             <td> { excAC8B.vimax } </td>
                                             <td> { excAC8B.vimin } </td>
                                             <td> { excAC8B.vpidmax } </td>
                                             <td> { excAC8B.vpidmin } </td>
                                             <td> { excAC8B.vrmax } </td>
                                             <td> { excAC8B.vrmin } </td>
                                             <td> { excAC8B.vtmult } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAC8B(excAC8B.excAC8BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC8B(excAC8B.excAC8BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC8B(excAC8B.excAC8BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC8BComponent
