import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService'

class ListPetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                petersenCoils: []
        }
        this.addPetersenCoil = this.addPetersenCoil.bind(this);
        this.editPetersenCoil = this.editPetersenCoil.bind(this);
        this.deletePetersenCoil = this.deletePetersenCoil.bind(this);
    }

    deletePetersenCoil(id){
        PetersenCoilService.deletePetersenCoil(id).then( res => {
            this.setState({petersenCoils: this.state.petersenCoils.filter(petersenCoil => petersenCoil.petersenCoilId !== id)});
        });
    }
    viewPetersenCoil(id){
        this.props.history.push(`/view-petersenCoil/${id}`);
    }
    editPetersenCoil(id){
        this.props.history.push(`/add-petersenCoil/${id}`);
    }

    componentDidMount(){
        PetersenCoilService.getPetersenCoils().then((res) => {
            this.setState({ petersenCoils: res.data});
        });
    }

    addPetersenCoil(){
        this.props.history.push('/add-petersenCoil/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PetersenCoil List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPetersenCoil}> Add PetersenCoil</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Mode </th>
                                    <th> NominalU </th>
                                    <th> OffsetCurrent </th>
                                    <th> PositionCurrent </th>
                                    <th> XGroundMax </th>
                                    <th> XGroundMin </th>
                                    <th> XGroundNominal </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.petersenCoils.map(
                                        petersenCoil => 
                                        <tr key = {petersenCoil.petersenCoilId}>
                                             <td> { petersenCoil.mode } </td>
                                             <td> { petersenCoil.nominalU } </td>
                                             <td> { petersenCoil.offsetCurrent } </td>
                                             <td> { petersenCoil.positionCurrent } </td>
                                             <td> { petersenCoil.xGroundMax } </td>
                                             <td> { petersenCoil.xGroundMin } </td>
                                             <td> { petersenCoil.xGroundNominal } </td>
                                             <td>
                                                 <button onClick={ () => this.editPetersenCoil(petersenCoil.petersenCoilId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePetersenCoil(petersenCoil.petersenCoilId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPetersenCoil(petersenCoil.petersenCoilId)} className="btn btn-info btn-sm">View </button>
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

export default ListPetersenCoilComponent
