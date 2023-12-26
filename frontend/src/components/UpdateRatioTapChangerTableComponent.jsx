import React, { Component } from 'react'
import RatioTapChangerTableService from '../services/RatioTapChangerTableService';

class UpdateRatioTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRatioTapChangerTable = this.updateRatioTapChangerTable.bind(this);

    }

    componentDidMount(){
        RatioTapChangerTableService.getRatioTapChangerTableById(this.state.id).then( (res) =>{
            let ratioTapChangerTable = res.data;
            this.setState({
            });
        });
    }

    updateRatioTapChangerTable = (e) => {
        e.preventDefault();
        let ratioTapChangerTable = {
            ratioTapChangerTableId: this.state.id,
        };
        console.log('ratioTapChangerTable => ' + JSON.stringify(ratioTapChangerTable));
        console.log('id => ' + JSON.stringify(this.state.id));
        RatioTapChangerTableService.updateRatioTapChangerTable(ratioTapChangerTable).then( res => {
            this.props.history.push('/ratioTapChangerTables');
        });
    }


    cancel(){
        this.props.history.push('/ratioTapChangerTables');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RatioTapChangerTable</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRatioTapChangerTable}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateRatioTapChangerTableComponent
