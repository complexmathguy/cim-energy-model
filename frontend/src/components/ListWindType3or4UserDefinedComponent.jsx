import React, { Component } from 'react'
import WindType3or4UserDefinedService from '../services/WindType3or4UserDefinedService'

class ListWindType3or4UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windType3or4UserDefineds: []
        }
        this.addWindType3or4UserDefined = this.addWindType3or4UserDefined.bind(this);
        this.editWindType3or4UserDefined = this.editWindType3or4UserDefined.bind(this);
        this.deleteWindType3or4UserDefined = this.deleteWindType3or4UserDefined.bind(this);
    }

    deleteWindType3or4UserDefined(id){
        WindType3or4UserDefinedService.deleteWindType3or4UserDefined(id).then( res => {
            this.setState({windType3or4UserDefineds: this.state.windType3or4UserDefineds.filter(windType3or4UserDefined => windType3or4UserDefined.windType3or4UserDefinedId !== id)});
        });
    }
    viewWindType3or4UserDefined(id){
        this.props.history.push(`/view-windType3or4UserDefined/${id}`);
    }
    editWindType3or4UserDefined(id){
        this.props.history.push(`/add-windType3or4UserDefined/${id}`);
    }

    componentDidMount(){
        WindType3or4UserDefinedService.getWindType3or4UserDefineds().then((res) => {
            this.setState({ windType3or4UserDefineds: res.data});
        });
    }

    addWindType3or4UserDefined(){
        this.props.history.push('/add-windType3or4UserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindType3or4UserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindType3or4UserDefined}> Add WindType3or4UserDefined</button>
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
                                    this.state.windType3or4UserDefineds.map(
                                        windType3or4UserDefined => 
                                        <tr key = {windType3or4UserDefined.windType3or4UserDefinedId}>
                                             <td> { windType3or4UserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindType3or4UserDefined(windType3or4UserDefined.windType3or4UserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindType3or4UserDefined(windType3or4UserDefined.windType3or4UserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindType3or4UserDefined(windType3or4UserDefined.windType3or4UserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindType3or4UserDefinedComponent
