import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service'

class ListExcAVR7Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR7s: []
        }
        this.addExcAVR7 = this.addExcAVR7.bind(this);
        this.editExcAVR7 = this.editExcAVR7.bind(this);
        this.deleteExcAVR7 = this.deleteExcAVR7.bind(this);
    }

    deleteExcAVR7(id){
        ExcAVR7Service.deleteExcAVR7(id).then( res => {
            this.setState({excAVR7s: this.state.excAVR7s.filter(excAVR7 => excAVR7.excAVR7Id !== id)});
        });
    }
    viewExcAVR7(id){
        this.props.history.push(`/view-excAVR7/${id}`);
    }
    editExcAVR7(id){
        this.props.history.push(`/add-excAVR7/${id}`);
    }

    componentDidMount(){
        ExcAVR7Service.getExcAVR7s().then((res) => {
            this.setState({ excAVR7s: res.data});
        });
    }

    addExcAVR7(){
        this.props.history.push('/add-excAVR7/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR7 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR7}> Add ExcAVR7</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A1 </th>
                                    <th> A2 </th>
                                    <th> A3 </th>
                                    <th> A4 </th>
                                    <th> A5 </th>
                                    <th> A6 </th>
                                    <th> K1 </th>
                                    <th> K3 </th>
                                    <th> K5 </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> Vmax1 </th>
                                    <th> Vmax3 </th>
                                    <th> Vmax5 </th>
                                    <th> Vmin1 </th>
                                    <th> Vmin3 </th>
                                    <th> Vmin5 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excAVR7s.map(
                                        excAVR7 => 
                                        <tr key = {excAVR7.excAVR7Id}>
                                             <td> { excAVR7.a1 } </td>
                                             <td> { excAVR7.a2 } </td>
                                             <td> { excAVR7.a3 } </td>
                                             <td> { excAVR7.a4 } </td>
                                             <td> { excAVR7.a5 } </td>
                                             <td> { excAVR7.a6 } </td>
                                             <td> { excAVR7.k1 } </td>
                                             <td> { excAVR7.k3 } </td>
                                             <td> { excAVR7.k5 } </td>
                                             <td> { excAVR7.t1 } </td>
                                             <td> { excAVR7.t2 } </td>
                                             <td> { excAVR7.t3 } </td>
                                             <td> { excAVR7.t4 } </td>
                                             <td> { excAVR7.t5 } </td>
                                             <td> { excAVR7.t6 } </td>
                                             <td> { excAVR7.vmax1 } </td>
                                             <td> { excAVR7.vmax3 } </td>
                                             <td> { excAVR7.vmax5 } </td>
                                             <td> { excAVR7.vmin1 } </td>
                                             <td> { excAVR7.vmin3 } </td>
                                             <td> { excAVR7.vmin5 } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR7(excAVR7.excAVR7Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR7(excAVR7.excAVR7Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR7(excAVR7.excAVR7Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR7Component
