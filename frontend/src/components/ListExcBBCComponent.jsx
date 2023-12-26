import React, { Component } from 'react'
import ExcBBCService from '../services/ExcBBCService'

class ListExcBBCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excBBCs: []
        }
        this.addExcBBC = this.addExcBBC.bind(this);
        this.editExcBBC = this.editExcBBC.bind(this);
        this.deleteExcBBC = this.deleteExcBBC.bind(this);
    }

    deleteExcBBC(id){
        ExcBBCService.deleteExcBBC(id).then( res => {
            this.setState({excBBCs: this.state.excBBCs.filter(excBBC => excBBC.excBBCId !== id)});
        });
    }
    viewExcBBC(id){
        this.props.history.push(`/view-excBBC/${id}`);
    }
    editExcBBC(id){
        this.props.history.push(`/add-excBBC/${id}`);
    }

    componentDidMount(){
        ExcBBCService.getExcBBCs().then((res) => {
            this.setState({ excBBCs: res.data});
        });
    }

    addExcBBC(){
        this.props.history.push('/add-excBBC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcBBC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcBBC}> Add ExcBBC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Efdmax </th>
                                    <th> Efdmin </th>
                                    <th> K </th>
                                    <th> SwitchIt </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Xe </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excBBCs.map(
                                        excBBC => 
                                        <tr key = {excBBC.excBBCId}>
                                             <td> { excBBC.efdmax } </td>
                                             <td> { excBBC.efdmin } </td>
                                             <td> { excBBC.k } </td>
                                             <td> { excBBC.switchIt } </td>
                                             <td> { excBBC.t1 } </td>
                                             <td> { excBBC.t2 } </td>
                                             <td> { excBBC.t3 } </td>
                                             <td> { excBBC.t4 } </td>
                                             <td> { excBBC.vrmax } </td>
                                             <td> { excBBC.vrmin } </td>
                                             <td> { excBBC.xe } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcBBC(excBBC.excBBCId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcBBC(excBBC.excBBCId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcBBC(excBBC.excBBCId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcBBCComponent
