import React, { Component } from 'react'
import WindPlantUserDefinedService from '../services/WindPlantUserDefinedService'

class ListWindPlantUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windPlantUserDefineds: []
        }
        this.addWindPlantUserDefined = this.addWindPlantUserDefined.bind(this);
        this.editWindPlantUserDefined = this.editWindPlantUserDefined.bind(this);
        this.deleteWindPlantUserDefined = this.deleteWindPlantUserDefined.bind(this);
    }

    deleteWindPlantUserDefined(id){
        WindPlantUserDefinedService.deleteWindPlantUserDefined(id).then( res => {
            this.setState({windPlantUserDefineds: this.state.windPlantUserDefineds.filter(windPlantUserDefined => windPlantUserDefined.windPlantUserDefinedId !== id)});
        });
    }
    viewWindPlantUserDefined(id){
        this.props.history.push(`/view-windPlantUserDefined/${id}`);
    }
    editWindPlantUserDefined(id){
        this.props.history.push(`/add-windPlantUserDefined/${id}`);
    }

    componentDidMount(){
        WindPlantUserDefinedService.getWindPlantUserDefineds().then((res) => {
            this.setState({ windPlantUserDefineds: res.data});
        });
    }

    addWindPlantUserDefined(){
        this.props.history.push('/add-windPlantUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindPlantUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindPlantUserDefined}> Add WindPlantUserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windPlantUserDefineds.map(
                                        windPlantUserDefined => 
                                        <tr key = {windPlantUserDefined.windPlantUserDefinedId}>
                                             <td> { windPlantUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindPlantUserDefined(windPlantUserDefined.windPlantUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindPlantUserDefined(windPlantUserDefined.windPlantUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindPlantUserDefined(windPlantUserDefined.windPlantUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindPlantUserDefinedComponent
