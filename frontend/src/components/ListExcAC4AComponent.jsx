import React, { Component } from 'react'
import ExcAC4AService from '../services/ExcAC4AService'

class ListExcAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC4As: []
        }
        this.addExcAC4A = this.addExcAC4A.bind(this);
        this.editExcAC4A = this.editExcAC4A.bind(this);
        this.deleteExcAC4A = this.deleteExcAC4A.bind(this);
    }

    deleteExcAC4A(id){
        ExcAC4AService.deleteExcAC4A(id).then( res => {
            this.setState({excAC4As: this.state.excAC4As.filter(excAC4A => excAC4A.excAC4AId !== id)});
        });
    }
    viewExcAC4A(id){
        this.props.history.push(`/view-excAC4A/${id}`);
    }
    editExcAC4A(id){
        this.props.history.push(`/add-excAC4A/${id}`);
    }

    componentDidMount(){
        ExcAC4AService.getExcAC4As().then((res) => {
            this.setState({ excAC4As: res.data});
        });
    }

    addExcAC4A(){
        this.props.history.push('/add-excAC4A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC4A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC4A}> Add ExcAC4A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ka </th>
                                    <th> Kc </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Tc </th>
                                    <th> Vimax </th>
                                    <th> Vimin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAC4As.map(
                                        excAC4A => 
                                        <tr key = {excAC4A.excAC4AId}>
                                             <td> { excAC4A.ka } </td>
                                             <td> { excAC4A.kc } </td>
                                             <td> { excAC4A.ta } </td>
                                             <td> { excAC4A.tb } </td>
                                             <td> { excAC4A.tc } </td>
                                             <td> { excAC4A.vimax } </td>
                                             <td> { excAC4A.vimin } </td>
                                             <td> { excAC4A.vrmax } </td>
                                             <td> { excAC4A.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAC4A(excAC4A.excAC4AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC4A(excAC4A.excAC4AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC4A(excAC4A.excAC4AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC4AComponent
