import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService'

class ListGovHydroPeltonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroPeltons: []
        }
        this.addGovHydroPelton = this.addGovHydroPelton.bind(this);
        this.editGovHydroPelton = this.editGovHydroPelton.bind(this);
        this.deleteGovHydroPelton = this.deleteGovHydroPelton.bind(this);
    }

    deleteGovHydroPelton(id){
        GovHydroPeltonService.deleteGovHydroPelton(id).then( res => {
            this.setState({govHydroPeltons: this.state.govHydroPeltons.filter(govHydroPelton => govHydroPelton.govHydroPeltonId !== id)});
        });
    }
    viewGovHydroPelton(id){
        this.props.history.push(`/view-govHydroPelton/${id}`);
    }
    editGovHydroPelton(id){
        this.props.history.push(`/add-govHydroPelton/${id}`);
    }

    componentDidMount(){
        GovHydroPeltonService.getGovHydroPeltons().then((res) => {
            this.setState({ govHydroPeltons: res.data});
        });
    }

    addGovHydroPelton(){
        this.props.history.push('/add-govHydroPelton/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroPelton List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroPelton}> Add GovHydroPelton</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Av0 </th>
                                    <th> Av1 </th>
                                    <th> Bp </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> H1 </th>
                                    <th> H2 </th>
                                    <th> Hn </th>
                                    <th> Kc </th>
                                    <th> Kg </th>
                                    <th> Qc0 </th>
                                    <th> Qn </th>
                                    <th> SimplifiedPelton </th>
                                    <th> StaticCompensating </th>
                                    <th> Ta </th>
                                    <th> Ts </th>
                                    <th> Tv </th>
                                    <th> Twnc </th>
                                    <th> Twng </th>
                                    <th> Tx </th>
                                    <th> Va </th>
                                    <th> Valvmax </th>
                                    <th> Valvmin </th>
                                    <th> Vav </th>
                                    <th> Vc </th>
                                    <th> Vcv </th>
                                    <th> WaterTunnelSurgeChamberSimulation </th>
                                    <th> Zsfc </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroPeltons.map(
                                        govHydroPelton => 
                                        <tr key = {govHydroPelton.govHydroPeltonId}>
                                             <td> { govHydroPelton.av0 } </td>
                                             <td> { govHydroPelton.av1 } </td>
                                             <td> { govHydroPelton.bp } </td>
                                             <td> { govHydroPelton.db1 } </td>
                                             <td> { govHydroPelton.db2 } </td>
                                             <td> { govHydroPelton.h1 } </td>
                                             <td> { govHydroPelton.h2 } </td>
                                             <td> { govHydroPelton.hn } </td>
                                             <td> { govHydroPelton.kc } </td>
                                             <td> { govHydroPelton.kg } </td>
                                             <td> { govHydroPelton.qc0 } </td>
                                             <td> { govHydroPelton.qn } </td>
                                             <td> { govHydroPelton.simplifiedPelton } </td>
                                             <td> { govHydroPelton.staticCompensating } </td>
                                             <td> { govHydroPelton.ta } </td>
                                             <td> { govHydroPelton.ts } </td>
                                             <td> { govHydroPelton.tv } </td>
                                             <td> { govHydroPelton.twnc } </td>
                                             <td> { govHydroPelton.twng } </td>
                                             <td> { govHydroPelton.tx } </td>
                                             <td> { govHydroPelton.va } </td>
                                             <td> { govHydroPelton.valvmax } </td>
                                             <td> { govHydroPelton.valvmin } </td>
                                             <td> { govHydroPelton.vav } </td>
                                             <td> { govHydroPelton.vc } </td>
                                             <td> { govHydroPelton.vcv } </td>
                                             <td> { govHydroPelton.waterTunnelSurgeChamberSimulation } </td>
                                             <td> { govHydroPelton.zsfc } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroPelton(govHydroPelton.govHydroPeltonId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroPelton(govHydroPelton.govHydroPeltonId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroPelton(govHydroPelton.govHydroPeltonId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroPeltonComponent
