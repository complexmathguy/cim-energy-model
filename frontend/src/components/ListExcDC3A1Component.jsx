import React, { Component } from 'react'
import ExcDC3A1Service from '../services/ExcDC3A1Service'

class ListExcDC3A1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC3A1s: []
        }
        this.addExcDC3A1 = this.addExcDC3A1.bind(this);
        this.editExcDC3A1 = this.editExcDC3A1.bind(this);
        this.deleteExcDC3A1 = this.deleteExcDC3A1.bind(this);
    }

    deleteExcDC3A1(id){
        ExcDC3A1Service.deleteExcDC3A1(id).then( res => {
            this.setState({excDC3A1s: this.state.excDC3A1s.filter(excDC3A1 => excDC3A1.excDC3A1Id !== id)});
        });
    }
    viewExcDC3A1(id){
        this.props.history.push(`/view-excDC3A1/${id}`);
    }
    editExcDC3A1(id){
        this.props.history.push(`/add-excDC3A1/${id}`);
    }

    componentDidMount(){
        ExcDC3A1Service.getExcDC3A1s().then((res) => {
            this.setState({ excDC3A1s: res.data});
        });
    }

    addExcDC3A1(){
        this.props.history.push('/add-excDC3A1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC3A1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC3A1}> Add ExcDC3A1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Exclim </th>
                                    <th> Ka </th>
                                    <th> Ke </th>
                                    <th> Kf </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Ta </th>
                                    <th> Te </th>
                                    <th> Tf </th>
                                    <th> Vb1max </th>
                                    <th> Vblim </th>
                                    <th> Vbmax </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excDC3A1s.map(
                                        excDC3A1 => 
                                        <tr key = {excDC3A1.excDC3A1Id}>
                                             <td> { excDC3A1.exclim } </td>
                                             <td> { excDC3A1.ka } </td>
                                             <td> { excDC3A1.ke } </td>
                                             <td> { excDC3A1.kf } </td>
                                             <td> { excDC3A1.ki } </td>
                                             <td> { excDC3A1.kp } </td>
                                             <td> { excDC3A1.ta } </td>
                                             <td> { excDC3A1.te } </td>
                                             <td> { excDC3A1.tf } </td>
                                             <td> { excDC3A1.vb1max } </td>
                                             <td> { excDC3A1.vblim } </td>
                                             <td> { excDC3A1.vbmax } </td>
                                             <td> { excDC3A1.vrmax } </td>
                                             <td> { excDC3A1.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcDC3A1(excDC3A1.excDC3A1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC3A1(excDC3A1.excDC3A1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC3A1(excDC3A1.excDC3A1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC3A1Component
