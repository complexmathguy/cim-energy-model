import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService'

class ListVAdjIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                vAdjIEEEs: []
        }
        this.addVAdjIEEE = this.addVAdjIEEE.bind(this);
        this.editVAdjIEEE = this.editVAdjIEEE.bind(this);
        this.deleteVAdjIEEE = this.deleteVAdjIEEE.bind(this);
    }

    deleteVAdjIEEE(id){
        VAdjIEEEService.deleteVAdjIEEE(id).then( res => {
            this.setState({vAdjIEEEs: this.state.vAdjIEEEs.filter(vAdjIEEE => vAdjIEEE.vAdjIEEEId !== id)});
        });
    }
    viewVAdjIEEE(id){
        this.props.history.push(`/view-vAdjIEEE/${id}`);
    }
    editVAdjIEEE(id){
        this.props.history.push(`/add-vAdjIEEE/${id}`);
    }

    componentDidMount(){
        VAdjIEEEService.getVAdjIEEEs().then((res) => {
            this.setState({ vAdjIEEEs: res.data});
        });
    }

    addVAdjIEEE(){
        this.props.history.push('/add-vAdjIEEE/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VAdjIEEE List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVAdjIEEE}> Add VAdjIEEE</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Adjslew </th>
                                    <th> Taoff </th>
                                    <th> Taon </th>
                                    <th> Vadjf </th>
                                    <th> Vadjmax </th>
                                    <th> Vadjmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.vAdjIEEEs.map(
                                        vAdjIEEE => 
                                        <tr key = {vAdjIEEE.vAdjIEEEId}>
                                             <td> { vAdjIEEE.adjslew } </td>
                                             <td> { vAdjIEEE.taoff } </td>
                                             <td> { vAdjIEEE.taon } </td>
                                             <td> { vAdjIEEE.vadjf } </td>
                                             <td> { vAdjIEEE.vadjmax } </td>
                                             <td> { vAdjIEEE.vadjmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editVAdjIEEE(vAdjIEEE.vAdjIEEEId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVAdjIEEE(vAdjIEEE.vAdjIEEEId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVAdjIEEE(vAdjIEEE.vAdjIEEEId)} className="btn btn-info btn-sm">View </button>
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

export default ListVAdjIEEEComponent
