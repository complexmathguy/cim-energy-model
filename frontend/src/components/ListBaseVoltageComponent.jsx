import React, { Component } from 'react'
import BaseVoltageService from '../services/BaseVoltageService'

class ListBaseVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                baseVoltages: []
        }
        this.addBaseVoltage = this.addBaseVoltage.bind(this);
        this.editBaseVoltage = this.editBaseVoltage.bind(this);
        this.deleteBaseVoltage = this.deleteBaseVoltage.bind(this);
    }

    deleteBaseVoltage(id){
        BaseVoltageService.deleteBaseVoltage(id).then( res => {
            this.setState({baseVoltages: this.state.baseVoltages.filter(baseVoltage => baseVoltage.baseVoltageId !== id)});
        });
    }
    viewBaseVoltage(id){
        this.props.history.push(`/view-baseVoltage/${id}`);
    }
    editBaseVoltage(id){
        this.props.history.push(`/add-baseVoltage/${id}`);
    }

    componentDidMount(){
        BaseVoltageService.getBaseVoltages().then((res) => {
            this.setState({ baseVoltages: res.data});
        });
    }

    addBaseVoltage(){
        this.props.history.push('/add-baseVoltage/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">BaseVoltage List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBaseVoltage}> Add BaseVoltage</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> NominalVoltage </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.baseVoltages.map(
                                        baseVoltage => 
                                        <tr key = {baseVoltage.baseVoltageId}>
                                             <td> { baseVoltage.nominalVoltage } </td>
                                             <td>
                                                 <button onClick={ () => this.editBaseVoltage(baseVoltage.baseVoltageId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBaseVoltage(baseVoltage.baseVoltageId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBaseVoltage(baseVoltage.baseVoltageId)} className="btn btn-info btn-sm">View </button>
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

export default ListBaseVoltageComponent
