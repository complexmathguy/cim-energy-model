import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService'

class ListIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                identifiedObjects: []
        }
        this.addIdentifiedObject = this.addIdentifiedObject.bind(this);
        this.editIdentifiedObject = this.editIdentifiedObject.bind(this);
        this.deleteIdentifiedObject = this.deleteIdentifiedObject.bind(this);
    }

    deleteIdentifiedObject(id){
        IdentifiedObjectService.deleteIdentifiedObject(id).then( res => {
            this.setState({identifiedObjects: this.state.identifiedObjects.filter(identifiedObject => identifiedObject.identifiedObjectId !== id)});
        });
    }
    viewIdentifiedObject(id){
        this.props.history.push(`/view-identifiedObject/${id}`);
    }
    editIdentifiedObject(id){
        this.props.history.push(`/add-identifiedObject/${id}`);
    }

    componentDidMount(){
        IdentifiedObjectService.getIdentifiedObjects().then((res) => {
            this.setState({ identifiedObjects: res.data});
        });
    }

    addIdentifiedObject(){
        this.props.history.push('/add-identifiedObject/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">IdentifiedObject List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addIdentifiedObject}> Add IdentifiedObject</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Description </th>
                                    <th> EnergyIdentCodeEic </th>
                                    <th> MRID </th>
                                    <th> Name </th>
                                    <th> ShortName </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.identifiedObjects.map(
                                        identifiedObject => 
                                        <tr key = {identifiedObject.identifiedObjectId}>
                                             <td> { identifiedObject.description } </td>
                                             <td> { identifiedObject.energyIdentCodeEic } </td>
                                             <td> { identifiedObject.mRID } </td>
                                             <td> { identifiedObject.name } </td>
                                             <td> { identifiedObject.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editIdentifiedObject(identifiedObject.identifiedObjectId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteIdentifiedObject(identifiedObject.identifiedObjectId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewIdentifiedObject(identifiedObject.identifiedObjectId)} className="btn btn-info btn-sm">View </button>
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

export default ListIdentifiedObjectComponent
