import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service'

class ListGovHydro1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro1s: []
        }
        this.addGovHydro1 = this.addGovHydro1.bind(this);
        this.editGovHydro1 = this.editGovHydro1.bind(this);
        this.deleteGovHydro1 = this.deleteGovHydro1.bind(this);
    }

    deleteGovHydro1(id){
        GovHydro1Service.deleteGovHydro1(id).then( res => {
            this.setState({govHydro1s: this.state.govHydro1s.filter(govHydro1 => govHydro1.govHydro1Id !== id)});
        });
    }
    viewGovHydro1(id){
        this.props.history.push(`/view-govHydro1/${id}`);
    }
    editGovHydro1(id){
        this.props.history.push(`/add-govHydro1/${id}`);
    }

    componentDidMount(){
        GovHydro1Service.getGovHydro1s().then((res) => {
            this.setState({ govHydro1s: res.data});
        });
    }

    addGovHydro1(){
        this.props.history.push('/add-govHydro1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro1}> Add GovHydro1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> At </th>
                                    <th> Dturb </th>
                                    <th> Gmax </th>
                                    <th> Gmin </th>
                                    <th> Hdam </th>
                                    <th> Mwbase </th>
                                    <th> Qnl </th>
                                    <th> Rperm </th>
                                    <th> Rtemp </th>
                                    <th> Tf </th>
                                    <th> Tg </th>
                                    <th> Tr </th>
                                    <th> Tw </th>
                                    <th> Velm </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydro1s.map(
                                        govHydro1 => 
                                        <tr key = {govHydro1.govHydro1Id}>
                                             <td> { govHydro1.at } </td>
                                             <td> { govHydro1.dturb } </td>
                                             <td> { govHydro1.gmax } </td>
                                             <td> { govHydro1.gmin } </td>
                                             <td> { govHydro1.hdam } </td>
                                             <td> { govHydro1.mwbase } </td>
                                             <td> { govHydro1.qnl } </td>
                                             <td> { govHydro1.rperm } </td>
                                             <td> { govHydro1.rtemp } </td>
                                             <td> { govHydro1.tf } </td>
                                             <td> { govHydro1.tg } </td>
                                             <td> { govHydro1.tr } </td>
                                             <td> { govHydro1.tw } </td>
                                             <td> { govHydro1.velm } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro1(govHydro1.govHydro1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro1(govHydro1.govHydro1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro1(govHydro1.govHydro1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro1Component
