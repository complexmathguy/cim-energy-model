import React, { Component } from 'react'
import RatioTapChangerTablePointService from '../services/RatioTapChangerTablePointService';

class CreateRatioTapChangerTablePointComponent extends Component {
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
            RatioTapChangerTablePointService.getRatioTapChangerTablePointById(this.state.id).then( (res) =>{
                let ratioTapChangerTablePoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRatioTapChangerTablePoint = (e) => {
        e.preventDefault();
        let ratioTapChangerTablePoint = {
                ratioTapChangerTablePointId: this.state.id,
            };
        console.log('ratioTapChangerTablePoint => ' + JSON.stringify(ratioTapChangerTablePoint));

        // step 5
        if(this.state.id === '_add'){
            ratioTapChangerTablePoint.ratioTapChangerTablePointId=''
            RatioTapChangerTablePointService.createRatioTapChangerTablePoint(ratioTapChangerTablePoint).then(res =>{
                this.props.history.push('/ratioTapChangerTablePoints');
            });
        }else{
            RatioTapChangerTablePointService.updateRatioTapChangerTablePoint(ratioTapChangerTablePoint).then( res => {
                this.props.history.push('/ratioTapChangerTablePoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/ratioTapChangerTablePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RatioTapChangerTablePoint</h3>
        }else{
            return <h3 className="text-center">Update RatioTapChangerTablePoint</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRatioTapChangerTablePoint}>Save</button>
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

export default CreateRatioTapChangerTablePointComponent
