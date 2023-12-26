import React, { Component } from 'react'
import ExcAVR1Service from '../services/ExcAVR1Service'

class ListExcAVR1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR1s: []
        }
        this.addExcAVR1 = this.addExcAVR1.bind(this);
        this.editExcAVR1 = this.editExcAVR1.bind(this);
        this.deleteExcAVR1 = this.deleteExcAVR1.bind(this);
    }

    deleteExcAVR1(id){
        ExcAVR1Service.deleteExcAVR1(id).then( res => {
            this.setState({excAVR1s: this.state.excAVR1s.filter(excAVR1 => excAVR1.excAVR1Id !== id)});
        });
    }
    viewExcAVR1(id){
        this.props.history.push(`/view-excAVR1/${id}`);
    }
    editExcAVR1(id){
        this.props.history.push(`/add-excAVR1/${id}`);
    }

    componentDidMount(){
        ExcAVR1Service.getExcAVR1s().then((res) => {
            this.setState({ excAVR1s: res.data});
        });
    }

    addExcAVR1(){
        this.props.history.push('/add-excAVR1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR1}> Add ExcAVR1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> E1 </th>
                                    <th> E2 </th>
                                    <th> Ka </th>
                                    <th> Kf </th>
                                    <th> Se1 </th>
                                    <th> Se2 </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Vrmn </th>
                                    <th> Vrmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAVR1s.map(
                                        excAVR1 => 
                                        <tr key = {excAVR1.excAVR1Id}>
                                             <td> { excAVR1.e1 } </td>
                                             <td> { excAVR1.e2 } </td>
                                             <td> { excAVR1.ka } </td>
                                             <td> { excAVR1.kf } </td>
                                             <td> { excAVR1.se1 } </td>
                                             <td> { excAVR1.se2 } </td>
                                             <td> { excAVR1.ta } </td>
                                             <td> { excAVR1.tb } </td>
                                             <td> { excAVR1.te } </td>
                                             <td> { excAVR1.tf } </td>
                                             <td> { excAVR1.vrmn } </td>
                                             <td> { excAVR1.vrmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR1(excAVR1.excAVR1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR1(excAVR1.excAVR1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR1(excAVR1.excAVR1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR1Component
