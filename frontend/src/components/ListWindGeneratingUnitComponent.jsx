import React, { Component } from 'react'
import WindGeneratingUnitService from '../services/WindGeneratingUnitService'

class ListWindGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windGeneratingUnits: []
        }
        this.addWindGeneratingUnit = this.addWindGeneratingUnit.bind(this);
        this.editWindGeneratingUnit = this.editWindGeneratingUnit.bind(this);
        this.deleteWindGeneratingUnit = this.deleteWindGeneratingUnit.bind(this);
    }

    deleteWindGeneratingUnit(id){
        WindGeneratingUnitService.deleteWindGeneratingUnit(id).then( res => {
            this.setState({windGeneratingUnits: this.state.windGeneratingUnits.filter(windGeneratingUnit => windGeneratingUnit.windGeneratingUnitId !== id)});
        });
    }
    viewWindGeneratingUnit(id){
        this.props.history.push(`/view-windGeneratingUnit/${id}`);
    }
    editWindGeneratingUnit(id){
        this.props.history.push(`/add-windGeneratingUnit/${id}`);
    }

    componentDidMount(){
        WindGeneratingUnitService.getWindGeneratingUnits().then((res) => {
            this.setState({ windGeneratingUnits: res.data});
        });
    }

    addWindGeneratingUnit(){
        this.props.history.push('/add-windGeneratingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindGeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindGeneratingUnit}> Add WindGeneratingUnit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> WindGenUnitType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windGeneratingUnits.map(
                                        windGeneratingUnit => 
                                        <tr key = {windGeneratingUnit.windGeneratingUnitId}>
                                             <td> { windGeneratingUnit.windGenUnitType } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindGeneratingUnit(windGeneratingUnit.windGeneratingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindGeneratingUnit(windGeneratingUnit.windGeneratingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindGeneratingUnit(windGeneratingUnit.windGeneratingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindGeneratingUnitComponent
