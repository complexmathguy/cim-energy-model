import React, { Component } from 'react'
import WindType1or2UserDefinedService from '../services/WindType1or2UserDefinedService'

class ListWindType1or2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windType1or2UserDefineds: []
        }
        this.addWindType1or2UserDefined = this.addWindType1or2UserDefined.bind(this);
        this.editWindType1or2UserDefined = this.editWindType1or2UserDefined.bind(this);
        this.deleteWindType1or2UserDefined = this.deleteWindType1or2UserDefined.bind(this);
    }

    deleteWindType1or2UserDefined(id){
        WindType1or2UserDefinedService.deleteWindType1or2UserDefined(id).then( res => {
            this.setState({windType1or2UserDefineds: this.state.windType1or2UserDefineds.filter(windType1or2UserDefined => windType1or2UserDefined.windType1or2UserDefinedId !== id)});
        });
    }
    viewWindType1or2UserDefined(id){
        this.props.history.push(`/view-windType1or2UserDefined/${id}`);
    }
    editWindType1or2UserDefined(id){
        this.props.history.push(`/add-windType1or2UserDefined/${id}`);
    }

    componentDidMount(){
        WindType1or2UserDefinedService.getWindType1or2UserDefineds().then((res) => {
            this.setState({ windType1or2UserDefineds: res.data});
        });
    }

    addWindType1or2UserDefined(){
        this.props.history.push('/add-windType1or2UserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindType1or2UserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindType1or2UserDefined}> Add WindType1or2UserDefined</button>
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
                                    this.state.windType1or2UserDefineds.map(
                                        windType1or2UserDefined => 
                                        <tr key = {windType1or2UserDefined.windType1or2UserDefinedId}>
                                             <td> { windType1or2UserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindType1or2UserDefined(windType1or2UserDefined.windType1or2UserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindType1or2UserDefined(windType1or2UserDefined.windType1or2UserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindType1or2UserDefined(windType1or2UserDefined.windType1or2UserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindType1or2UserDefinedComponent
