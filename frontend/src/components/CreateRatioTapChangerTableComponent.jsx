import React, { Component } from 'react'
import RatioTapChangerTableService from '../services/RatioTapChangerTableService';

class CreateRatioTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            RatioTapChangerTableService.getRatioTapChangerTableById(this.state.id).then( (res) =>{
                let ratioTapChangerTable = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRatioTapChangerTable = (e) => {
        e.preventDefault();
        let ratioTapChangerTable = {
                ratioTapChangerTableId: this.state.id,
            };
        console.log('ratioTapChangerTable => ' + JSON.stringify(ratioTapChangerTable));

        // step 5
        if(this.state.id === '_add'){
            ratioTapChangerTable.ratioTapChangerTableId=''
            RatioTapChangerTableService.createRatioTapChangerTable(ratioTapChangerTable).then(res =>{
                this.props.history.push('/ratioTapChangerTables');
            });
        }else{
            RatioTapChangerTableService.updateRatioTapChangerTable(ratioTapChangerTable).then( res => {
                this.props.history.push('/ratioTapChangerTables');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/ratioTapChangerTables');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RatioTapChangerTable</h3>
        }else{
            return <h3 className="text-center">Update RatioTapChangerTable</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRatioTapChangerTable}>Save</button>
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

export default CreateRatioTapChangerTableComponent
