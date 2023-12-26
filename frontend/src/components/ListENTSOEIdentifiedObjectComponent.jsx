import React, { Component } from 'react'
import ENTSOEIdentifiedObjectService from '../services/ENTSOEIdentifiedObjectService'

class ListENTSOEIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                eNTSOEIdentifiedObjects: []
        }
        this.addENTSOEIdentifiedObject = this.addENTSOEIdentifiedObject.bind(this);
        this.editENTSOEIdentifiedObject = this.editENTSOEIdentifiedObject.bind(this);
        this.deleteENTSOEIdentifiedObject = this.deleteENTSOEIdentifiedObject.bind(this);
    }

    deleteENTSOEIdentifiedObject(id){
        ENTSOEIdentifiedObjectService.deleteENTSOEIdentifiedObject(id).then( res => {
            this.setState({eNTSOEIdentifiedObjects: this.state.eNTSOEIdentifiedObjects.filter(eNTSOEIdentifiedObject => eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId !== id)});
        });
    }
    viewENTSOEIdentifiedObject(id){
        this.props.history.push(`/view-eNTSOEIdentifiedObject/${id}`);
    }
    editENTSOEIdentifiedObject(id){
        this.props.history.push(`/add-eNTSOEIdentifiedObject/${id}`);
    }

    componentDidMount(){
        ENTSOEIdentifiedObjectService.getENTSOEIdentifiedObjects().then((res) => {
            this.setState({ eNTSOEIdentifiedObjects: res.data});
        });
    }

    addENTSOEIdentifiedObject(){
        this.props.history.push('/add-eNTSOEIdentifiedObject/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ENTSOEIdentifiedObject List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addENTSOEIdentifiedObject}> Add ENTSOEIdentifiedObject</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> EnergyIdentCodeEic </th>
                                    <th> ShortName </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.eNTSOEIdentifiedObjects.map(
                                        eNTSOEIdentifiedObject => 
                                        <tr key = {eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId}>
                                             <td> { eNTSOEIdentifiedObject.energyIdentCodeEic } </td>
                                             <td> { eNTSOEIdentifiedObject.shortName } </td>
                                             <td>
                                                 <button onClick={ () => this.editENTSOEIdentifiedObject(eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteENTSOEIdentifiedObject(eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewENTSOEIdentifiedObject(eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId)} className="btn btn-info btn-sm">View </button>
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

export default ListENTSOEIdentifiedObjectComponent
