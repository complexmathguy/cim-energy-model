import React, { Component } from 'react'
import ExcAVR3Service from '../services/ExcAVR3Service'

class ListExcAVR3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR3s: []
        }
        this.addExcAVR3 = this.addExcAVR3.bind(this);
        this.editExcAVR3 = this.editExcAVR3.bind(this);
        this.deleteExcAVR3 = this.deleteExcAVR3.bind(this);
    }

    deleteExcAVR3(id){
        ExcAVR3Service.deleteExcAVR3(id).then( res => {
            this.setState({excAVR3s: this.state.excAVR3s.filter(excAVR3 => excAVR3.excAVR3Id !== id)});
        });
    }
    viewExcAVR3(id){
        this.props.history.push(`/view-excAVR3/${id}`);
    }
    editExcAVR3(id){
        this.props.history.push(`/add-excAVR3/${id}`);
    }

    componentDidMount(){
        ExcAVR3Service.getExcAVR3s().then((res) => {
            this.setState({ excAVR3s: res.data});
        });
    }

    addExcAVR3(){
        this.props.history.push('/add-excAVR3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR3}> Add ExcAVR3</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> E1 </th>
                                    <th> E2 </th>
                                    <th> Ka </th>
                                    <th> Se1 </th>
                                    <th> Se2 </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> Te </th>
                                    <th> Vrmn </th>
                                    <th> Vrmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAVR3s.map(
                                        excAVR3 => 
                                        <tr key = {excAVR3.excAVR3Id}>
                                             <td> { excAVR3.e1 } </td>
                                             <td> { excAVR3.e2 } </td>
                                             <td> { excAVR3.ka } </td>
                                             <td> { excAVR3.se1 } </td>
                                             <td> { excAVR3.se2 } </td>
                                             <td> { excAVR3.t1 } </td>
                                             <td> { excAVR3.t2 } </td>
                                             <td> { excAVR3.t3 } </td>
                                             <td> { excAVR3.t4 } </td>
                                             <td> { excAVR3.te } </td>
                                             <td> { excAVR3.vrmn } </td>
                                             <td> { excAVR3.vrmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR3(excAVR3.excAVR3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR3(excAVR3.excAVR3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR3(excAVR3.excAVR3Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR3Component
