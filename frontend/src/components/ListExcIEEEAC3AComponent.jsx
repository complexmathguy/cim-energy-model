import React, { Component } from 'react'
import ExcIEEEAC3AService from '../services/ExcIEEEAC3AService'

class ListExcIEEEAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC3As: []
        }
        this.addExcIEEEAC3A = this.addExcIEEEAC3A.bind(this);
        this.editExcIEEEAC3A = this.editExcIEEEAC3A.bind(this);
        this.deleteExcIEEEAC3A = this.deleteExcIEEEAC3A.bind(this);
    }

    deleteExcIEEEAC3A(id){
        ExcIEEEAC3AService.deleteExcIEEEAC3A(id).then( res => {
            this.setState({excIEEEAC3As: this.state.excIEEEAC3As.filter(excIEEEAC3A => excIEEEAC3A.excIEEEAC3AId !== id)});
        });
    }
    viewExcIEEEAC3A(id){
        this.props.history.push(`/view-excIEEEAC3A/${id}`);
    }
    editExcIEEEAC3A(id){
        this.props.history.push(`/add-excIEEEAC3A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC3AService.getExcIEEEAC3As().then((res) => {
            this.setState({ excIEEEAC3As: res.data});
        });
    }

    addExcIEEEAC3A(){
        this.props.history.push('/add-excIEEEAC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC3A}> Add ExcIEEEAC3A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdn </th>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Kd </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Kn </th>
                                    <th> Kr </th>
                                    <th> Seve1 </th>
                                    <th> Seve2 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Vamax </th>
                                    <th> Vamin </th>
                                    <th> Ve1 </th>
                                    <th> Ve2 </th>
                                    <th> Vemin </th>
                                    <th> Vfemax </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEAC3As.map(
                                        excIEEEAC3A => 
                                        <tr key = {excIEEEAC3A.excIEEEAC3AId}>
                                             <td> { excIEEEAC3A.efdn } </td>
                                             <td> { excIEEEAC3A.ka } </td>
                                             <td> { excIEEEAC3A.kc } </td>
                                             <td> { excIEEEAC3A.kd } </td>
                                             <td> { excIEEEAC3A.ke } </td>
                                             <td> { excIEEEAC3A.kf } </td>
                                             <td> { excIEEEAC3A.kn } </td>
                                             <td> { excIEEEAC3A.kr } </td>
                                             <td> { excIEEEAC3A.seve1 } </td>
                                             <td> { excIEEEAC3A.seve2 } </td>
                                             <td> { excIEEEAC3A.ta } </td>
                                             <td> { excIEEEAC3A.tb } </td>
                                             <td> { excIEEEAC3A.tc } </td>
                                             <td> { excIEEEAC3A.te } </td>
                                             <td> { excIEEEAC3A.tf } </td>
                                             <td> { excIEEEAC3A.vamax } </td>
                                             <td> { excIEEEAC3A.vamin } </td>
                                             <td> { excIEEEAC3A.ve1 } </td>
                                             <td> { excIEEEAC3A.ve2 } </td>
                                             <td> { excIEEEAC3A.vemin } </td>
                                             <td> { excIEEEAC3A.vfemax } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC3A(excIEEEAC3A.excIEEEAC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC3A(excIEEEAC3A.excIEEEAC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC3A(excIEEEAC3A.excIEEEAC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC3AComponent
