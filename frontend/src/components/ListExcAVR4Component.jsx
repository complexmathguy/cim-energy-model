import React, { Component } from 'react'
import ExcAVR4Service from '../services/ExcAVR4Service'

class ListExcAVR4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR4s: []
        }
        this.addExcAVR4 = this.addExcAVR4.bind(this);
        this.editExcAVR4 = this.editExcAVR4.bind(this);
        this.deleteExcAVR4 = this.deleteExcAVR4.bind(this);
    }

    deleteExcAVR4(id){
        ExcAVR4Service.deleteExcAVR4(id).then( res => {
            this.setState({excAVR4s: this.state.excAVR4s.filter(excAVR4 => excAVR4.excAVR4Id !== id)});
        });
    }
    viewExcAVR4(id){
        this.props.history.push(`/view-excAVR4/${id}`);
    }
    editExcAVR4(id){
        this.props.history.push(`/add-excAVR4/${id}`);
    }

    componentDidMount(){
        ExcAVR4Service.getExcAVR4s().then((res) => {
            this.setState({ excAVR4s: res.data});
        });
    }

    addExcAVR4(){
        this.props.history.push('/add-excAVR4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR4}> Add ExcAVR4</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Imul </th>
                                    <th> Ka </th>
                                    <th> Ke </th>
                                    <th> Kif </th>
                                    <th> T1 </th>
                                    <th> T1if </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> Tif </th>
                                    <th> Vfmn </th>
                                    <th> Vfmx </th>
                                    <th> Vrmn </th>
                                    <th> Vrmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAVR4s.map(
                                        excAVR4 => 
                                        <tr key = {excAVR4.excAVR4Id}>
                                             <td> { excAVR4.imul } </td>
                                             <td> { excAVR4.ka } </td>
                                             <td> { excAVR4.ke } </td>
                                             <td> { excAVR4.kif } </td>
                                             <td> { excAVR4.t1 } </td>
                                             <td> { excAVR4.t1if } </td>
                                             <td> { excAVR4.t2 } </td>
                                             <td> { excAVR4.t3 } </td>
                                             <td> { excAVR4.t4 } </td>
                                             <td> { excAVR4.tif } </td>
                                             <td> { excAVR4.vfmn } </td>
                                             <td> { excAVR4.vfmx } </td>
                                             <td> { excAVR4.vrmn } </td>
                                             <td> { excAVR4.vrmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR4(excAVR4.excAVR4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR4(excAVR4.excAVR4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR4(excAVR4.excAVR4Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR4Component
