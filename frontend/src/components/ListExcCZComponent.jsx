import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService'

class ListExcCZComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excCZs: []
        }
        this.addExcCZ = this.addExcCZ.bind(this);
        this.editExcCZ = this.editExcCZ.bind(this);
        this.deleteExcCZ = this.deleteExcCZ.bind(this);
    }

    deleteExcCZ(id){
        ExcCZService.deleteExcCZ(id).then( res => {
            this.setState({excCZs: this.state.excCZs.filter(excCZ => excCZ.excCZId !== id)});
        });
    }
    viewExcCZ(id){
        this.props.history.push(`/view-excCZ/${id}`);
    }
    editExcCZ(id){
        this.props.history.push(`/add-excCZ/${id}`);
    }

    componentDidMount(){
        ExcCZService.getExcCZs().then((res) => {
            this.setState({ excCZs: res.data});
        });
    }

    addExcCZ(){
        this.props.history.push('/add-excCZ/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcCZ List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcCZ}> Add ExcCZ</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdmax </th>
                                    <th> Efdmin </th>
                                    <th> Ka </th>
                                    <th> Ke </th>
                                    <th> Kp </th>
                                    <th> Ta </th>
                                    <th> Tc </th>
                                    <th> Te </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excCZs.map(
                                        excCZ => 
                                        <tr key = {excCZ.excCZId}>
                                             <td> { excCZ.efdmax } </td>
                                             <td> { excCZ.efdmin } </td>
                                             <td> { excCZ.ka } </td>
                                             <td> { excCZ.ke } </td>
                                             <td> { excCZ.kp } </td>
                                             <td> { excCZ.ta } </td>
                                             <td> { excCZ.tc } </td>
                                             <td> { excCZ.te } </td>
                                             <td> { excCZ.vrmax } </td>
                                             <td> { excCZ.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcCZ(excCZ.excCZId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcCZ(excCZ.excCZId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcCZ(excCZ.excCZId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcCZComponent
