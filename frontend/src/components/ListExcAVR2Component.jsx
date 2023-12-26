import React, { Component } from 'react'
import ExcAVR2Service from '../services/ExcAVR2Service'

class ListExcAVR2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR2s: []
        }
        this.addExcAVR2 = this.addExcAVR2.bind(this);
        this.editExcAVR2 = this.editExcAVR2.bind(this);
        this.deleteExcAVR2 = this.deleteExcAVR2.bind(this);
    }

    deleteExcAVR2(id){
        ExcAVR2Service.deleteExcAVR2(id).then( res => {
            this.setState({excAVR2s: this.state.excAVR2s.filter(excAVR2 => excAVR2.excAVR2Id !== id)});
        });
    }
    viewExcAVR2(id){
        this.props.history.push(`/view-excAVR2/${id}`);
    }
    editExcAVR2(id){
        this.props.history.push(`/add-excAVR2/${id}`);
    }

    componentDidMount(){
        ExcAVR2Service.getExcAVR2s().then((res) => {
            this.setState({ excAVR2s: res.data});
        });
    }

    addExcAVR2(){
        this.props.history.push('/add-excAVR2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR2}> Add ExcAVR2</button>
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
                                    <th> Tf1 </th>
                                    <th> Tf2 </th>
                                    <th> Vrmn </th>
                                    <th> Vrmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAVR2s.map(
                                        excAVR2 => 
                                        <tr key = {excAVR2.excAVR2Id}>
                                             <td> { excAVR2.e1 } </td>
                                             <td> { excAVR2.e2 } </td>
                                             <td> { excAVR2.ka } </td>
                                             <td> { excAVR2.kf } </td>
                                             <td> { excAVR2.se1 } </td>
                                             <td> { excAVR2.se2 } </td>
                                             <td> { excAVR2.ta } </td>
                                             <td> { excAVR2.tb } </td>
                                             <td> { excAVR2.te } </td>
                                             <td> { excAVR2.tf1 } </td>
                                             <td> { excAVR2.tf2 } </td>
                                             <td> { excAVR2.vrmn } </td>
                                             <td> { excAVR2.vrmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR2(excAVR2.excAVR2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR2(excAVR2.excAVR2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR2(excAVR2.excAVR2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR2Component
