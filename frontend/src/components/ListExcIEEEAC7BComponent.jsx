import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService'

class ListExcIEEEAC7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC7Bs: []
        }
        this.addExcIEEEAC7B = this.addExcIEEEAC7B.bind(this);
        this.editExcIEEEAC7B = this.editExcIEEEAC7B.bind(this);
        this.deleteExcIEEEAC7B = this.deleteExcIEEEAC7B.bind(this);
    }

    deleteExcIEEEAC7B(id){
        ExcIEEEAC7BService.deleteExcIEEEAC7B(id).then( res => {
            this.setState({excIEEEAC7Bs: this.state.excIEEEAC7Bs.filter(excIEEEAC7B => excIEEEAC7B.excIEEEAC7BId !== id)});
        });
    }
    viewExcIEEEAC7B(id){
        this.props.history.push(`/view-excIEEEAC7B/${id}`);
    }
    editExcIEEEAC7B(id){
        this.props.history.push(`/add-excIEEEAC7B/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC7BService.getExcIEEEAC7Bs().then((res) => {
            this.setState({ excIEEEAC7Bs: res.data});
        });
    }

    addExcIEEEAC7B(){
        this.props.history.push('/add-excIEEEAC7B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC7B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC7B}> Add ExcIEEEAC7B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Kdr </th>
                                    <th> Ke </th>
                                    <th> Kf1 </th>
                                    <th> Kf2 </th>
                                    <th> Kf3 </th>
                                    <th> Kia </th>
                                    <th> Kir </th>
                                    <th> Kl </th>
                                    <th> Kp </th>
                                    <th> Kpa </th>
                                    <th> Kpr </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Tdr </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Vamax </th>
                                    <th> Vamin </th>
                                    <th> Ve1 </th>
                                    <th> Ve2 </th>
                                    <th> Vemin </th>
                                    <th> Vfemax </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEAC7Bs.map(
                                        excIEEEAC7B => 
                                        <tr key = {excIEEEAC7B.excIEEEAC7BId}>
                                             <td> { excIEEEAC7B.kc } </td>
                                             <td> { excIEEEAC7B.kd } </td>
                                             <td> { excIEEEAC7B.kdr } </td>
                                             <td> { excIEEEAC7B.ke } </td>
                                             <td> { excIEEEAC7B.kf1 } </td>
                                             <td> { excIEEEAC7B.kf2 } </td>
                                             <td> { excIEEEAC7B.kf3 } </td>
                                             <td> { excIEEEAC7B.kia } </td>
                                             <td> { excIEEEAC7B.kir } </td>
                                             <td> { excIEEEAC7B.kl } </td>
                                             <td> { excIEEEAC7B.kp } </td>
                                             <td> { excIEEEAC7B.kpa } </td>
                                             <td> { excIEEEAC7B.kpr } </td>
                                             <td> { excIEEEAC7B.seve1 } </td>
                                             <td> { excIEEEAC7B.seve2 } </td>
                                             <td> { excIEEEAC7B.tdr } </td>
                                             <td> { excIEEEAC7B.te } </td>
                                             <td> { excIEEEAC7B.tf } </td>
                                             <td> { excIEEEAC7B.vamax } </td>
                                             <td> { excIEEEAC7B.vamin } </td>
                                             <td> { excIEEEAC7B.ve1 } </td>
                                             <td> { excIEEEAC7B.ve2 } </td>
                                             <td> { excIEEEAC7B.vemin } </td>
                                             <td> { excIEEEAC7B.vfemax } </td>
                                             <td> { excIEEEAC7B.vrmax } </td>
                                             <td> { excIEEEAC7B.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC7B(excIEEEAC7B.excIEEEAC7BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC7B(excIEEEAC7B.excIEEEAC7BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC7B(excIEEEAC7B.excIEEEAC7BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC7BComponent
