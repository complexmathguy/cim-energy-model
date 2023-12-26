import React, { Component } from 'react'
import ExcIEEEAC8BService from '../services/ExcIEEEAC8BService'

class ListExcIEEEAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC8Bs: []
        }
        this.addExcIEEEAC8B = this.addExcIEEEAC8B.bind(this);
        this.editExcIEEEAC8B = this.editExcIEEEAC8B.bind(this);
        this.deleteExcIEEEAC8B = this.deleteExcIEEEAC8B.bind(this);
    }

    deleteExcIEEEAC8B(id){
        ExcIEEEAC8BService.deleteExcIEEEAC8B(id).then( res => {
            this.setState({excIEEEAC8Bs: this.state.excIEEEAC8Bs.filter(excIEEEAC8B => excIEEEAC8B.excIEEEAC8BId !== id)});
        });
    }
    viewExcIEEEAC8B(id){
        this.props.history.push(`/view-excIEEEAC8B/${id}`);
    }
    editExcIEEEAC8B(id){
        this.props.history.push(`/add-excIEEEAC8B/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC8BService.getExcIEEEAC8Bs().then((res) => {
            this.setState({ excIEEEAC8Bs: res.data});
        });
    }

    addExcIEEEAC8B(){
        this.props.history.push('/add-excIEEEAC8B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC8B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC8B}> Add ExcIEEEAC8B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Kdr </th>
                                    <th> Ke </th>
                                    <th> Kir </th>
                                    <th> Kpr </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Ta </th>
                                    <th> Tdr </th>
                                    <th> Te </th>
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
                                    this.state.excIEEEAC8Bs.map(
                                        excIEEEAC8B => 
                                        <tr key = {excIEEEAC8B.excIEEEAC8BId}>
                                             <td> { excIEEEAC8B.ka } </td>
                                             <td> { excIEEEAC8B.kc } </td>
                                             <td> { excIEEEAC8B.kd } </td>
                                             <td> { excIEEEAC8B.kdr } </td>
                                             <td> { excIEEEAC8B.ke } </td>
                                             <td> { excIEEEAC8B.kir } </td>
                                             <td> { excIEEEAC8B.kpr } </td>
                                             <td> { excIEEEAC8B.seve1 } </td>
                                             <td> { excIEEEAC8B.seve2 } </td>
                                             <td> { excIEEEAC8B.ta } </td>
                                             <td> { excIEEEAC8B.tdr } </td>
                                             <td> { excIEEEAC8B.te } </td>
                                             <td> { excIEEEAC8B.ve1 } </td>
                                             <td> { excIEEEAC8B.ve2 } </td>
                                             <td> { excIEEEAC8B.vemin } </td>
                                             <td> { excIEEEAC8B.vfemax } </td>
                                             <td> { excIEEEAC8B.vrmax } </td>
                                             <td> { excIEEEAC8B.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC8B(excIEEEAC8B.excIEEEAC8BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC8B(excIEEEAC8B.excIEEEAC8BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC8B(excIEEEAC8B.excIEEEAC8BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC8BComponent
