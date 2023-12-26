import React, { Component } from 'react'
import CsConverterService from '../services/CsConverterService'

class ListCsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                csConverters: []
        }
        this.addCsConverter = this.addCsConverter.bind(this);
        this.editCsConverter = this.editCsConverter.bind(this);
        this.deleteCsConverter = this.deleteCsConverter.bind(this);
    }

    deleteCsConverter(id){
        CsConverterService.deleteCsConverter(id).then( res => {
            this.setState({csConverters: this.state.csConverters.filter(csConverter => csConverter.csConverterId !== id)});
        });
    }
    viewCsConverter(id){
        this.props.history.push(`/view-csConverter/${id}`);
    }
    editCsConverter(id){
        this.props.history.push(`/add-csConverter/${id}`);
    }

    componentDidMount(){
        CsConverterService.getCsConverters().then((res) => {
            this.setState({ csConverters: res.data});
        });
    }

    addCsConverter(){
        this.props.history.push('/add-csConverter/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">CsConverter List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addCsConverter}> Add CsConverter</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> MaxAlpha </th>
                                    <th> MaxGamma </th>
                                    <th> MaxIdc </th>
                                    <th> MinAlpha </th>
                                    <th> MinGamma </th>
                                    <th> MinIdc </th>
                                    <th> RatedIdc </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.csConverters.map(
                                        csConverter => 
                                        <tr key = {csConverter.csConverterId}>
                                             <td> { csConverter.maxAlpha } </td>
                                             <td> { csConverter.maxGamma } </td>
                                             <td> { csConverter.maxIdc } </td>
                                             <td> { csConverter.minAlpha } </td>
                                             <td> { csConverter.minGamma } </td>
                                             <td> { csConverter.minIdc } </td>
                                             <td> { csConverter.ratedIdc } </td>
                                             <td>
                                                 <button onClick={ () => this.editCsConverter(csConverter.csConverterId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteCsConverter(csConverter.csConverterId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewCsConverter(csConverter.csConverterId)} className="btn btn-info btn-sm">View </button>
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

export default ListCsConverterComponent
