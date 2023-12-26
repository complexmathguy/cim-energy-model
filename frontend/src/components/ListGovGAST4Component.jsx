import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service'

class ListGovGAST4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGAST4s: []
        }
        this.addGovGAST4 = this.addGovGAST4.bind(this);
        this.editGovGAST4 = this.editGovGAST4.bind(this);
        this.deleteGovGAST4 = this.deleteGovGAST4.bind(this);
    }

    deleteGovGAST4(id){
        GovGAST4Service.deleteGovGAST4(id).then( res => {
            this.setState({govGAST4s: this.state.govGAST4s.filter(govGAST4 => govGAST4.govGAST4Id !== id)});
        });
    }
    viewGovGAST4(id){
        this.props.history.push(`/view-govGAST4/${id}`);
    }
    editGovGAST4(id){
        this.props.history.push(`/add-govGAST4/${id}`);
    }

    componentDidMount(){
        GovGAST4Service.getGovGAST4s().then((res) => {
            this.setState({ govGAST4s: res.data});
        });
    }

    addGovGAST4(){
        this.props.history.push('/add-govGAST4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST4}> Add GovGAST4</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Bp </th>
                                    <th> Ktm </th>
                                    <th> Mnef </th>
                                    <th> Mxef </th>
                                    <th> Rymn </th>
                                    <th> Rymx </th>
                                    <th> Ta </th>
                                    <th> Tc </th>
                                    <th> Tcm </th>
                                    <th> Tm </th>
                                    <th> Tv </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govGAST4s.map(
                                        govGAST4 => 
                                        <tr key = {govGAST4.govGAST4Id}>
                                             <td> { govGAST4.bp } </td>
                                             <td> { govGAST4.ktm } </td>
                                             <td> { govGAST4.mnef } </td>
                                             <td> { govGAST4.mxef } </td>
                                             <td> { govGAST4.rymn } </td>
                                             <td> { govGAST4.rymx } </td>
                                             <td> { govGAST4.ta } </td>
                                             <td> { govGAST4.tc } </td>
                                             <td> { govGAST4.tcm } </td>
                                             <td> { govGAST4.tm } </td>
                                             <td> { govGAST4.tv } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST4(govGAST4.govGAST4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST4(govGAST4.govGAST4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST4(govGAST4.govGAST4Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGAST4Component
