import React, { Component } from 'react'
import ExcAC3AService from '../services/ExcAC3AService'

class ListExcAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC3As: []
        }
        this.addExcAC3A = this.addExcAC3A.bind(this);
        this.editExcAC3A = this.editExcAC3A.bind(this);
        this.deleteExcAC3A = this.deleteExcAC3A.bind(this);
    }

    deleteExcAC3A(id){
        ExcAC3AService.deleteExcAC3A(id).then( res => {
            this.setState({excAC3As: this.state.excAC3As.filter(excAC3A => excAC3A.excAC3AId !== id)});
        });
    }
    viewExcAC3A(id){
        this.props.history.push(`/view-excAC3A/${id}`);
    }
    editExcAC3A(id){
        this.props.history.push(`/add-excAC3A/${id}`);
    }

    componentDidMount(){
        ExcAC3AService.getExcAC3As().then((res) => {
            this.setState({ excAC3As: res.data});
        });
    }

    addExcAC3A(){
        this.props.history.push('/add-excAC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC3A}> Add ExcAC3A</button>
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
                                    <th> Kf1 </th>
                                    <th> Kf2 </th>
                                    <th> Klv </th>
                                    <th> Kn </th>
                                    <th> Kr </th>
                                    <th> Ks </th>
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
                                    <th> Vlv </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAC3As.map(
                                        excAC3A => 
                                        <tr key = {excAC3A.excAC3AId}>
                                             <td> { excAC3A.efdn } </td>
                                             <td> { excAC3A.ka } </td>
                                             <td> { excAC3A.kc } </td>
                                             <td> { excAC3A.kd } </td>
                                             <td> { excAC3A.ke } </td>
                                             <td> { excAC3A.kf } </td>
                                             <td> { excAC3A.kf1 } </td>
                                             <td> { excAC3A.kf2 } </td>
                                             <td> { excAC3A.klv } </td>
                                             <td> { excAC3A.kn } </td>
                                             <td> { excAC3A.kr } </td>
                                             <td> { excAC3A.ks } </td>
                                             <td> { excAC3A.seve1 } </td>
                                             <td> { excAC3A.seve2 } </td>
                                             <td> { excAC3A.ta } </td>
                                             <td> { excAC3A.tb } </td>
                                             <td> { excAC3A.tc } </td>
                                             <td> { excAC3A.te } </td>
                                             <td> { excAC3A.tf } </td>
                                             <td> { excAC3A.vamax } </td>
                                             <td> { excAC3A.vamin } </td>
                                             <td> { excAC3A.ve1 } </td>
                                             <td> { excAC3A.ve2 } </td>
                                             <td> { excAC3A.vemin } </td>
                                             <td> { excAC3A.vfemax } </td>
                                             <td> { excAC3A.vlv } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAC3A(excAC3A.excAC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC3A(excAC3A.excAC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC3A(excAC3A.excAC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC3AComponent
